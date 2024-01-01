package org.interview.trycatchfinallyquestion;

/**
 * 先做 finally 才回傳
 */
public class TryDemo1 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.print("3");
        }
    }
}
