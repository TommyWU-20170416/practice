package org.wsi.threedaypractice.day1.juc.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 是一個執行緒池的實現類，它是 ExecutorService 的實現類
 * 比起 Executor 可以配置更多設定
 * <p>
 * 常見的
 * 1. corePoolSize：核心執行緒數，即使執行緒處於閒置狀態，也會保留在池中的執行緒數量。
 * 2. maximumPoolSize：Thread Pool 的最大數量，如果所有 Thread 都被執行的話 Task 會被塞到 Queue 之中等到有空閒的 Thread 為止
 * -- 決定 maxPoolSize 的數量最好是根據系統資源去計算出來 System.out.println(Runtime.getRuntime().availableProcessors());
 * 3. keepAliveTime：當執行緒池中的執行緒數量超過 corePoolSize 時，額外的閒置執行緒在等待新任務到來的最長時間。超過這個時間後，額外的執行緒會被終止。
 * 4. unit：keepAliveTime 參數的時間單位。
 * 5. workQueue：用於存放待執行任務的阻塞佇列。常用的有 ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue 等。
 * 6. handler：當執行緒池無法處理新來的任務時（例如，佇列已滿或執行緒池已關閉），這個拒絕策略會被調用。
 * -- JDK 提供了四種拒絕策略：
 * ---- AbortPolicy（預設，直接拋出異常）
 * ---- CallerRunsPolicy（用呼叫者的執行緒執行任務）
 * ---- DiscardPolicy（忽略新任務）
 * ---- DiscardOldestPolicy（丟棄佇列中最舊的任務，然後嘗試添加新任務）。
 */
public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, // corePoolSize
                10, // maximumPoolSize
                60, // keepAliveTime
                TimeUnit.SECONDS, // unit
                new LinkedBlockingQueue<>(100), // workQueue
                Executors.defaultThreadFactory(), // threadFactory
                new ThreadPoolExecutor.AbortPolicy() // handler
        );

        for (int i = 0; i < 10; i++) {
            int finalI = i; // 如果在 lambda 中使用 i，則 i 必須是 final 或 effectively final
            // effectively final 指的是變量只能賦值一次，不能再次賦值，也就是執行結束前都不能改變
            executor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + finalI + " is running on: " + threadName);
//                System.out.println("Task " + i + " is running on: " + threadName);
            });
        }

        executor.shutdown();
    }
}