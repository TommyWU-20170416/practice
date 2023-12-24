package org.interview.abstractandinterface;

interface MyInterface {
    // 常量
    String INTERFACE_VAR = "Interface - Variable";

    // 抽象方法
    void interfaceMethod();

    // 默認方法
    // 提供給實現類一個默認的行為且不影響原本的實作
    // 若有需要，實現類也可自己重寫內容
    default void defaultMethod() {
        System.out.println("Interface - defaultMethod");
    }

    // 靜態方法
    static void staticMethod() {
        System.out.println("Interface - staticMethod");
    }

    /**
     * 被禁用的 靜態代碼塊
     */
//    static {
//        System.out.println("Abstract - static block");
//    }
}
