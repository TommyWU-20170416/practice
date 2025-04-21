package org.wsi.info;

/**
 * 同時有多個執行緒在進行提款
 * <p>
 * 使用 synchronized 限制多線程提領
 */
public class BankAccount {

    private int balance;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " 正在提款 " + amount);
            balance -= amount;
            System.out.println("剩餘餘額: " + balance);
        } else {
            System.out.println("餘額不足");
        }
    }
}
