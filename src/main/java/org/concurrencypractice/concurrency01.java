package org.concurrencypractice;

/**
 * 課程來源：https://www.youtube.com/watch?v=t2SgaeCOZjA&list=PLmOn9nNkQxJGuxM62QOkUwD_zroNZj-a7&index=4
 * 課程標題：04 尚硅谷 JUC高并发编程 JUC概述和进程线程概念（3）
 */
public class concurrency01 {
    public static void main(String[] args) {
        Thread aa = new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true){}
        }, "aa");

        aa.setDaemon(true); // 設定守護現程
        aa.start();
        System.out.println(Thread.currentThread().getName() + "over");

        // 如果是用戶現程，isDaemon返回 false
        // 如果是守護現程，isDaemon返回 true
    }
}
