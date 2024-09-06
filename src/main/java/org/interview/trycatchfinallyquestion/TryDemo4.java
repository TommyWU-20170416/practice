package org.interview.trycatchfinallyquestion;

/**
 * catch 就跟 try 一樣
 */
public class TryDemo4 {
    public static void main(String[] args) {
        System.out.println("print: " + test());
    }

    public static int test() {
        int aa = 0;
        try {
            System.out.println("try: " + aa);
            aa = 2;
            System.out.println("try: " + aa);
            int a = 8 / 0; // 故意讓他跳到 catch
            return aa;
        } catch (Exception e) {
            System.out.println("catch: " + aa);
            aa = 3;
            System.out.println("catch: " + aa);
            return aa;
        } finally {
            System.out.println("finally: " + aa);
            aa = 4;
            System.out.println("finally: " + aa);
        }
    }
}