package org.wsi.info;

/**
 * 停止一個正在執行的 thread
 */
public class Worker {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("工作中...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("工作停止");
    }

    public void shutdown() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();

        Thread thread = new Thread(worker::run);

        thread.start(); // worker 開始工作

        Thread.sleep(2000);

        worker.shutdown();
        // 跟 worker 說工作停止，直到下一次 thread 檢查 running 時就會知道要停止工作
    }
}
