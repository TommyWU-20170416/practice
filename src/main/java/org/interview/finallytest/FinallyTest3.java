package org.interview.finallytest;

public class FinallyTest3 {
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
        } finally {
            System.out.println("Finally block");
            throw new RuntimeException("Exception in finally"); // 這裡會拋出異常
        }
    }
}
