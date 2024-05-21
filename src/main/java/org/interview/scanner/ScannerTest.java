package org.interview.scanner;

import java.util.Scanner;
/**
 * 30-2.https://www.hackerrank.com/challenges/30-data-types/problem?isFullScreen=true
 *
 * @author AaronWU
 * @created 創建時間：2024/05/21 16:21:29
 * @since JDK8.0
 */

/**
 * 當執行程式後，在裡面輸入
 * 1\n
 * 2.0\n
 * is the best
 * \n就是換行，然後觀察看看下面的 scan.nextInt 或是 scan.nextLine 發生什麼事情
 */
public class ScannerTest {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);

        int i2 = 0;
        double d2 = 0;
        String s2 = "";

        // 如果是這樣的情境，輸入三行後就會被關掉輸入
        // 1\n2.0\nis the best
        i2 = scan.nextInt();    // 執行後 緩衝區剩下: \n2.0\nis the best
        d2 = scan.nextDouble(); // 執行後 緩衝區剩下: \nis the best
        scan.nextLine();        // 執行後 緩衝區剩下: is the best         => nextLine 會消耗掉 \n
        s2 = scan.nextLine();   // 執行後 緩衝區剩下: 沒東西

        // 如果是這樣的情境，輸入兩行後就會被關掉輸入
        // 1\n2.0\nis the best
//        i2 = scan.nextInt();    // 執行後 緩衝區剩下: \n2.0\n
//        d2 = scan.nextDouble(); // 執行後 緩衝區剩下: \n
//        s2 = scan.nextLine();   // 執行後 緩衝區剩下: 沒東西                 => nextLine 會消耗掉 \n

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s + s2);
        scan.close();
    }
}