package org.wsi.threedaypractice.day1.juc;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        Callable<String> task = () -> {
            return "Hello, Callable!";
        };

        try {
            String result = task.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runnable task2 = () -> {
            System.out.println("Hello, Runnable!");
        };
        try {
            task2.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}