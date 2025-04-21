package org.wsi.info;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 針對死鎖的解法
 * <p>
 * 使用 ReentrantLock 這種非阻塞式的進行鎖的訪問，如果拿不到鎖就返回
 */
public class DeadLockSol {

    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        if (lockA.tryLock(100, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println("Thread 1: Holding lock A...");
                Thread.sleep(100);
                if (lockB.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 1: Acquired lock B!");
                    } finally {
                        lockB.unlock();
                    }
                } else {
                    System.out.println("Thread 1: Could not acquire lock B, releasing lock A.");
                }
            } finally {
                lockA.unlock();
            }
        }
    }
}
