package org.wsi.threedaypractice.day1.threadandrunnable;

/**
 * 除了 MyThread 這個類別外，我們也可以使用 Runnable 這個介面來實作執行緒。
 * 其實 Thread 也是實作 Runnable 這個介面，只是 Thread 這個類別多了一些方法，但是 Runnable 這個介面只有一個 run() 方法。
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
