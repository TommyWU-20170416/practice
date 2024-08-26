package org.wsi.threedaypractice.day1.synchronizedandvolatile;

/**
 * 使用 volatile 關鍵字的情況下，多執行序取用資料
 * 這關鍵字可以確保，取用的執行序是可以取得最新的資料(可見性以及順序性)
 *
 * 可見性：count 有變動的話，每個 thread 都可以看得到
 * 順序性：count 有變動的話，每個 thread 都可以看得到(不確定實用地方)
 *
 * 理論上總數應該是 20000。但由於這些操作不是原子性的
 * 兩個線程可能會互相覆蓋對方的結果，導致最終的 count 值小於 200。
 * 因此不是加上 volatile 就保證了線程安全。
 */
public class VolatileCounter {
    private volatile int count = 0;

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
        VolatileCounter counterRace = new VolatileCounter();

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
            System.out.println(counterRace.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
