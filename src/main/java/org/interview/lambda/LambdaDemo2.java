package org.interview.lambda;

import org.junit.Test;

public class LambdaDemo2 {
    public static void main(String[] args) {
        /**
         * 告訴 MyInterface 我要使用 String 當作 T 做聲明
         * 裡面的 @Override 就不用在聲明一次
         */
        MyInterfaceDemo2<String> myString = new MyInterfaceDemo2<String>() {
            @Override
            public <T> T getValue(T t) {
                return t;
            }
        };
        System.out.println(myString.getValue("Hello Lambda"));

        /**
         * 換成 Integer 一樣的概念
         */
        MyInterfaceDemo2<Integer> myInteger = new MyInterfaceDemo2<Integer>() {
            @Override
            public <T> T getValue(T t) {
                return t;
            }
        };
        System.out.println(myInteger.getValue(123456));
    }
}
