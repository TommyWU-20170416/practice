package org.interview.trycatchfinallyquestion;

/**
 * 先做 finally 所以先回傳
 */
public class TryDemo2 {
    public static void main(String[] args) {
        System.out.println("print: " + test());
    }

    private static int test() {
        try {
            return 1;
        } finally {
            return 3;// 跟 TryDemo1 比較，改了這行
        }
    }
}
