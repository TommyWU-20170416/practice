package org.datastructuresandalgorithms.hiskio;

public class Fibonacci {
    public static Integer fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i) + " ");
            // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
        }
    }
}
