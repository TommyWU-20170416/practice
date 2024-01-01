package org.interview.trycatchfinallyquestion;

/**
 * try 跟 catch 一樣都有自己暫存
 * finally 本就不是拿來做修改變數，而是拿來釋放資源或清除，所以沒有暫存的功能
 */
public class TryDemo4 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int i = 0;
        try {
            i = 2;
            int a = 8 / 0;
            return i;
        } catch (Exception e) {
            i = 3;
            return i;
        } finally {
            i = 4;
        }
    }
}