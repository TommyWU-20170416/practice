package org.interview.statictest;

public class StaticTest {
    final static String STATICTESTSTRING = "STRING";

    public static void main(String[] args) {
//        instanceMethod();// 錯誤。Non-static method 'instanceMethod()' cannot be referenced from a static context
        StaticTest staticTest = new StaticTest();
        staticTest.instanceMethod();
    }


    private void instanceMethod() {
        System.out.println("I am not static method");
    }
}
