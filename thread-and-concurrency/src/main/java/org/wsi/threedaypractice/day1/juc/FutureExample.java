package org.wsi.threedaypractice.day1.juc;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            Thread.sleep(1000);
            return "Hello, Future!";
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task); // submit 後就會馬上執行，並且返回一個 future 的物件，提供後續使用

        /**
         * get()：等待任務完成並獲取結果，若任務未完成則會阻塞。因為搭配 Callable 所以才會有返回值
         * isDone()：檢查任務是否已完成。
         * cancel(boolean mayInterruptIfRunning)：取消任務的執行。
         */
        try {
            System.out.println(future.get());
            System.out.println(future.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}