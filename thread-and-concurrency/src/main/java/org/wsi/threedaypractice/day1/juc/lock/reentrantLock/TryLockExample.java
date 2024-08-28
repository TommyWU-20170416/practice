package org.wsi.threedaypractice.day1.juc.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock() 在詢問有沒有鎖的時候，不會被 block 住，而是直接回傳 true 或 false
 * tryLock(long timeout, TimeUnit unit) 方法嘗試獲取鎖的過程中被中斷，該方法會立即拋出 InterruptedException。
 */
public class TryLockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock");
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " acquired the lock");
                        Thread.sleep(2000);  // Simulate some work
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName() + " released the lock");
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " could not acquire the lock");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");

        thread1.start();
        thread2.start();
    }
}