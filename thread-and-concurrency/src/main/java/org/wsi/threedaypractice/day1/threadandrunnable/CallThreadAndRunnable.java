package org.wsi.threedaypractice.day1.threadandrunnable;

public class CallThreadAndRunnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

//        MyRunnable myRunnable = new MyRunnable(); // 這樣呼叫一樣會是 main，因為這樣寫會當據當下的 thread 去執行
//        myRunnable.run();
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
