package org.wsi.threedaypractice.day1.synchronizedandvolatile;

/**
 * 不使用同步的情況下，多執行序取用資料
 */
public class CounterRace {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        CounterRace counterRace = new CounterRace();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counterRace.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counterRace.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("count: " + counterRace.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
