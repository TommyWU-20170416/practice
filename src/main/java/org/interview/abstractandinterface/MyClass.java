package org.interview.abstractandinterface;

import java.util.ArrayList;
import java.util.List;

public class MyClass extends AbstractClass implements MyInterface {
    /**
     * ---------------- 抽象 ----------------
     */
    // 實現抽象方法
    @Override
    void abstractMethod() {
        System.out.println("MyClass - abstract - abstractMethod");
    }

    // 重寫具體方法
    @Override
    void concreteMethod() { System.out.println("MyClass - abstract - concreteMethod"); }
    /**
     * ---------------- 抽象 ----------------
     */

    /**
     * ---------------- 接口 ----------------
     */
    // 實現接口方法
    @Override
    public void interfaceMethod() {
        System.out.println("MyClass - interface - interfaceMethod");
    }

    @Override
    public void defaultMethod() {
        System.out.println("MyClass - interface - defaultMethod");
    }

    /**
     * ---------------- 接口 ----------------
     */

    public static void main(String[] args) {
        // 實例化 MyClass
        MyClass myClass = new MyClass();

        // 存取抽象類的實例變數和方法
        System.out.println(myClass.abstractVar);
        // 'privateAbstractString' has private access in 'org.interview.abstractandinterface.AbstractClass'
        // System.out.println(myClass.privateAbstractString);
        myClass.concreteMethod();
        myClass.abstractMethod();
        myClass.staticMethod();

        // 存取接口的常量和方法
        System.out.println(MyInterface.INTERFACE_VAR);
        myClass.interfaceMethod();
        myClass.defaultMethod();
        MyInterface.staticMethod();
    }

}