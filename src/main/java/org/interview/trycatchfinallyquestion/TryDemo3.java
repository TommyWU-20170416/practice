package org.interview.trycatchfinallyquestion;

/**
 * try 有自己暫存的變數，其他人無法改變
 */
public class TryDemo3 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int aa = 0;
        try {
            aa = 2;
            return aa;
        } finally {
            aa = 4;
        }
    }
}
/**
 * 下面是編譯後的編碼，有興趣的可以看看
 * 對 class 執行 javap -c 可以看內容
 */
//javap -c TryDemo3.class
//Compiled from "TryDemo3.java"
//public class org.interview.trycatchfinallyquestion.TryDemo3 {
//public org.interview.trycatchfinallyquestion.TryDemo3();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: invokestatic  #3                  // Method test:()I
//        6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
//        9: return
//
//public static int test();
//        Code:
//        0: iconst_0   // 把 0 放到 stack 內
//        1: istore_0   // 把 stack 第一個值存到本地變量 0 (也就是 aa)
//        int i = 0;

//        2: iconst_2   // 把 2 放到 stack 內
//        3: istore_0   // 把 stack 第一個值存到本地變量 0 (也就是 aa)
//        i = 2;

//        4: iload_0    // 把 本地變量 0 放回 stack 內準備
//        5: istore_1   // 把 stack 第一個值存到本地變量 1
//        這邊是另外暫存出來的變數(本地變量1)，原本的(本地變量0)，給後面的 finally 繼續使用

//        6: iconst_4   // 把 4 放到 stack 內
//        7: istore_0   // 把 stack 第一個值存到本地變量 0 (也就是 aa) => i = 4;
//        i = 4;

//        8: iload_1    // 把 本地變量 1 放回 stack 內準備 return     => 此時已經知道 return 是 2
//        9: ireturn    // 返回 stack 第一個值

//        10: astore_2
//        11: iconst_4
//        12: istore_0
//        13: aload_2
//        14: athrow
//        Exception table:
//        from    to  target type
//        2     6    10   any
//        }