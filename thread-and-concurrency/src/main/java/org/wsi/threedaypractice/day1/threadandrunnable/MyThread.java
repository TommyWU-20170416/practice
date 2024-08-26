package org.wsi.threedaypractice.day1.threadandrunnable;

/**
 * Thread：Java 中的執行緒是通過 Thread 類來表示的，你可以通過繼承 Thread 類來創建一個執行緒。
 *
 * 一般我們都是 main 主程序這個執行序在做事，而我們定義 MyThread 並且取啟用他，這樣就會有兩個執行緒在跑。
 * 因此輸出會有 main + Thread-0 這兩個執行緒在跑。
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
