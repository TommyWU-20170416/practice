package org.wsi.info.threadLocalScene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 大致模擬資料庫連線池的概念
 */
public class ThreadLocalDemo1 {

    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        Connection conn = connectionHolder.get();

        if (conn == null) {
            // 如果當前線程沒有連接，則創建一個新的連接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user", "password");
            conn.setAutoCommit(false); // 開啟交易控制
            connectionHolder.set(conn);
        }
        return conn;
    }

    public static void commitAndClose() throws SQLException{
        Connection conn = connectionHolder.get();

        if(null != conn){
            conn.commit();
            conn.close(); // 不會真正關閉資料庫連線，而是將連線標記為可用，並放回連線池中，供其他執行緒使用。
            connectionHolder.remove();
            // 這行程式碼的作用是清除當前執行緒的 ThreadLocal 中所儲存的連線實例。
            // 如果不清除，且通常 Thread 都會是長時間運行的，這樣會導致 ThreadLocal 中的連線物件不斷增加。
            // ThreadLocal 會持續保留該連線的參考、甚至是上一次的資料，可能導致記憶體洩漏或其他問題。
        }
    }

    // rollback 如同 commitAndClose 也是相同作法
}
