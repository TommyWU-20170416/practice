package org.wsi.info;

/**
 * 練習 lock 使用 wait 以及 notify
 */
public class LockWhenCallWaitAndNotify {

    private final Object lock = new Object();

    public void waitEx() {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread is waiting...");
                    lock.wait();
                    System.out.println("Thread resumed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted");
                }
            }
        }).start();
    }

    public void notifyEx() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying waiting thread...");
                lock.notify();
                System.out.println("Notification sent.");
            }
        }).start();
    }

    public static void main(String[] args) {

        LockWhenCallWaitAndNotify instance = new LockWhenCallWaitAndNotify();
        instance.waitEx();
        instance.notifyEx();
    }
}
