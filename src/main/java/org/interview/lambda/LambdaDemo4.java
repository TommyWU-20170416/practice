package org.interview.lambda;

import org.junit.Test;

public class LambdaDemo4 {

    @Test
    public void test4() {
        MyInterfaceDemo4<String> myInterfaceDemo4 = new MyInterfaceDemo4<String>() {
            @Override
            public String getValue(String s) {
                return s;
            }
        };
        System.out.println(myInterfaceDemo4.getValue("abcd"));
    }

    /**
     * 這邊是證明 泛型方法 是無法被 lambda 取代。至少這寫法不行
     */
    @Test
    public void testGenerics2() {
//        MyInterfaceDemo2 myInterface = value -> value + " World"; // Target method is generic
//        myInterface.getValue("Hello");
    }

    /**
     * 使用 Lambda 改寫
     * 由於在接口的時候就明訂要回傳的型別，所以可用 lambda 改寫
     */
    @Test
    public void testGenerics3() {
        MyInterfaceDemo3<String> myInterface = value -> value + " World";
        String result = myInterface.getValue("Hello");
    }

    /**
     * 使用 Lambda 改寫
     * 由於在接口的時候就明訂要回傳的型別，所以可用 lambda 改寫
     */
    @Test
    public void testGenerics4() {
        MyInterfaceDemo4<String> myInterface = value -> value + " World";
        String result = myInterface.getValue("Hello");
    }
}
