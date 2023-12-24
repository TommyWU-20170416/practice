package org.interview.abstractandinterface;

abstract class AbstractClass {
    // 實例變數
    private String privateAbstractString = "Abstract - private - String";
    protected String abstractVar = "Abstract - protected - String";

    // 構造方法
    AbstractClass() {
        System.out.println("Abstract - contructor" + privateAbstractString);
    }

    // 抽象方法
    abstract void abstractMethod();

    // 具體方法
    void concreteMethod() {
        System.out.println("Abstract - method");
    }

    // 靜態方法
    static void staticMethod() {
        System.out.println("Abstract - staticMethod");
    }

    static{
        System.out.println("Abstract - static block");
    }
}
