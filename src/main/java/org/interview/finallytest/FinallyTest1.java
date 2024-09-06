package org.interview.finallytest;

public class FinallyTest1 {
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
            System.exit(0); // 終止 JVM
        } finally {
            System.out.println("Finally block"); // 不會執行
        }
    }
}
