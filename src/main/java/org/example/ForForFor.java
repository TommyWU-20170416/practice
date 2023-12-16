package org.example;

public class ForForFor {
    public static void main(String[] args) {
        String sentence = "";
        for (int iter = 0; iter < 1; iter++) {
            long total = 0, start = System.currentTimeMillis(), last = start;

            for (int i = 1; i < 100_000_000; i++) {
                sentence = String.valueOf(i); // 故意要讓他建新的變數到 stack
                total += sentence.chars().filter(Character::isUpperCase).count(); // 故意讓他去做比較，不然秒數會太少看不出差異
                if (i % 10_000_000 == 0) {
                    long now = System.currentTimeMillis();
                    System.out.printf("%d (%d ms)%n", i / 10_000_000, now - last);
                    last = now;
                }
            }
            System.out.printf("total: %d (%d ms)%n", total, System.currentTimeMillis() - start);
        }
    }
}
