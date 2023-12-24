package org.interview.initialtest;

/**
 * 靜態代碼塊載入類的時候一定會被呼叫一次
 * 接著是構造器，子類要被創建之前，父類要先創立
 */
public class InitialTest {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}

class A {
    static {
        System.out.println("A");
    }

    public A() {
        System.out.println("a");
    }
}

class B extends A {
    static {
        System.out.println("B");
    }

    public B() {
        System.out.println("b");
    }
}