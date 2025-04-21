package org.wsi.info.threadLocalScene;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期格式
 */
public class ThreadLocalDemo2 {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 實際測試不容易發生錯誤就是了，可能 CPU 處理極快
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                try {
                    // 嘗試格式化日期
                    String formattedDate = sdf.format(new Date());
                    System.out.println(Thread.currentThread().getName() + ": " + formattedDate);
                } catch (Exception e) {
                    // 捕獲並顯示錯誤
                    System.err.println(Thread.currentThread().getName() + " encountered an error: " + e.getMessage());
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
