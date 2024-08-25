package org.wsi.concurrencypractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread1 implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        return 200;
    }
}

public class FututeTaskPractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + " come in callable");
            Thread.sleep(3000);
            return 1024;
        });

        new Thread(futureTask2, "lucy").start();

        while(!futureTask2.isDone()){
//            System.out.println("waiting ...");
        }

        System.out.println(futureTask2.get());
        System.out.println(futureTask2.get()); // 第二次呼叫不會再次執行 FutureTask 的內容，而是等到第一次執行完成後，再一起 return
    }
    // 實作方法一

}
