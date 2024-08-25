package org.wsi.concurrencypractice;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 課程來源：https://www.youtube.com/watch?v=0gz3RKOlt1g&list=PLmOn9nNkQxJGuxM62QOkUwD_zroNZj-a7
 * 課程標題：14 尚硅谷 JUC高并发编程 集合线程安全 异常演示
 */

public class ThreadDemo4 {
    public static void main(String[] args) {
        /**
         * 解決辦法 - 改用有 synchronize
         */
        /** 使用 Vector，但方法有點老舊 JDK1.0 */
//        List<String> list = new Vector<>();
        /** 使用 Collections，但方法有點老舊 JDK1.2 */
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        /** 第三種推薦的方法 */
        List<String> list =new CopyOnWriteArrayList<String>();


//        List<String> list = new ArrayList<>();
        /** 當次數夠高，就會引發 Exception in thread "8" java.util.ConcurrentModificationException */
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

}
