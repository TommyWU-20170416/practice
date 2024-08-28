package org.wsi.threedaypractice.day1.juc.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ScheduledExecutorService 主要用於排程和執行延遲任務或定期任務
 */
public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        /**
         * 讓 主程序 等待 10 秒，過程中 延遲任務會執行一次，週期性任務會每 2 秒執行一次，直到 10 秒後結束
         */
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        // 延遲任務
        executor.schedule(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("-- Delayed task is running on: " + threadName);
        }, 2, TimeUnit.SECONDS);

        // 週期性任務
        executor.scheduleAtFixedRate(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Periodic task is running on: " + threadName);
        }, 0, 2, TimeUnit.SECONDS);

        // 等待所有任務完成
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        /**
         * 設定執行兩次後停止
         * incrementAndGet 會在運行的時候一起 +1
         */
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(5);
        AtomicInteger count = new AtomicInteger(0);

        // 週期性任務
        executor2.scheduleAtFixedRate(() ->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Periodic task is running on: 2 - " + threadName);
            if (count.incrementAndGet() == 2) {
                executor2.shutdown();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
