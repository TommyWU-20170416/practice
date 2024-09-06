package org.interview.finallytest;

public class FinallyTest2 {
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
            while (true) { // 死循環
            }
        } finally {
            System.out.println("Finally block"); // 不會執行
        }
    }
}
