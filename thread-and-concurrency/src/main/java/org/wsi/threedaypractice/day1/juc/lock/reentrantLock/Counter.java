package org.wsi.threedaypractice.day1.juc.lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用 ReentrantLock 來實現線程安全的計數器
 * 當新增或是讀取的時候都上鎖，確保新增的時候不會被覆蓋，讀取的時候不會讀到不一致的數據
 */
public class Counter {
//    ReentrantLock fairLock = new ReentrantLock(true);  // 公平鎖: 保證先來先服務，但是效率較低因為每次都要檢查誰先來
//    ReentrantLock unfairLock = new ReentrantLock(false); // 非公平鎖（預設）: 效率好，但可能有些 thread 會一直等待
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void incrementWithLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCountWithLock() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment(counter);
        counter.count = 0;
        counter.incrementWithoutLock(counter);
    }

    private void increment(Counter counter){

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + counter.getCountWithLock());
    }

    private void incrementWithoutLock(Counter counter){

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementWithLock();
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count: " + counter.getCountWithLock());
    }
}
