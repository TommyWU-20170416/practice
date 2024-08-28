package org.wsi.threedaypractice.day1.juc.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 練習使用 ReentrantLock 的 lockInterruptibly() 方法
 * <p>
 * 在多執行緒程式設計中，有時候我們可能需要中斷一個正在等待鎖的執行緒。這種情況通常發生在以下兩種情況：
 * 1. 死鎖檢測：如果您的程式可能會發生死鎖，您可能需要一種機制來中斷一個或多個等待鎖的執行緒，以解除死鎖狀態。
 * 2. 任務取消：如果您的程式中有一個長時間運行的任務，該任務可能會在等待一個鎖。如果您希望能夠取消這個任務，您可能需要中斷該任務的執行緒。
 * <p>
 * 在這些情況下，您可以使用 ReentrantLock 的 lockInterruptibly() 方法來獲取鎖。
 * 這個方法會對中斷進行響應，如果執行緒在等待鎖的過程中被中斷，則該方法會拋出 InterruptedException。
 * 這使得您可以使用 Thread 的 interrupt 方法來中斷等待鎖的執行緒。
 */
public class LockInterruptiblyExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Runnable task1 = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start to acquire the lock");
                // 如果當前的執行緒有空，就可以拿去用並繼續往下跑
                // 如果當前的執行緒沒有空，就會被 block 住，直到有空為止，等待的時候如果收到 中斷 通知，就會跳到 catch 區塊
                lock.lockInterruptibly();
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock");
                    Thread.sleep(2000);  // Simulate some work
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released the lock");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
            }
        };

        Thread thread1 = new Thread(task1, "Thread 1");
        Thread thread2 = new Thread(task1, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            // 雖然 thread1 先被 start，但還是要看 JVM 決定是 thread1 先執行還是 thread2 先執行，不過等待 500 毫秒後，可以盡量讓 thread1 先執行
            Thread.sleep(500);
            System.out.println("... wait 500 ms");
            thread2.interrupt();  // Interrupt Thread 2 while it's waiting for the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

