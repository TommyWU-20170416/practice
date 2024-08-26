package org.wsi.threedaypractice.day1.synchronizedandvolatile;

/**
 * 如果今天有多個執行序去做加一，由於有可能拿到的當下另一個 thread 已經 + 1 ，但手上的 thread 還在舊資料，就會有資料缺少的問題。
 * <p>
 * join() 方法用於讓當前執行緒等待被調用的執行緒結束，直到它完成執行。
 * 也就是說 主執行緒 調用 thread1.join() 和 thread2.join()
 * 意味著主執行緒會等待 thread1 和 thread2 兩個執行緒都結束後才會繼續執行。
 */
public class SynchronizedCounterRace {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        SynchronizedCounterRace counterRace = new SynchronizedCounterRace();

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
