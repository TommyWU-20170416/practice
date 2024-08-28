package org.wsi.threedaypractice.day1.juc;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor 是一個接口，它是一個執行緒池的工廠，用於創建和管理執行緒的核心介面，並且可創建 執行緒池
 */
public class ExecutorTest {
    public static void main(String[] args) {
        // 執行緒池管理執行緒的生命週期，調度並執行任務
        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello, Executor! " + threadName);
        });

        // 關閉執行緒池
        if (executor instanceof java.util.concurrent.ExecutorService) {
            ((java.util.concurrent.ExecutorService) executor).shutdown();
        }

        /**
         * 若提交超過 threadpool 的執行緒會發生什麼事情
         * 可以看到會等 2 秒，釋放 thread 後就可以執行新的
         */
        Executor executor2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executor2.execute(() ->{
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello, Executor2! " + threadName);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
