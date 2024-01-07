package org.interview.lambda;

import org.junit.Test;

public class LambdaDemo3 {

    /**
     * Step2. handleString 收到下面宣告的方式，並帶入到 myInterfaceDemo3.getValue 內
     * Steo3. 接著把參數 str 傳給 getValue(str) 並回傳內容
     */
    public String handleString(MyInterfaceDemo3<String> myInterfaceDemo3, String str) {
        return myInterfaceDemo3.getValue(str);
    }

    /**
     * Step1. 宣告 getValue 內要回傳 s.toUpperCase();
     */
    @Test
    public void test3() {
        String str = handleString(new MyInterfaceDemo3<String>() {
            @Override
            public String getValue(String s) {
                return s.toUpperCase();
            }
        }, "abcd");
        System.out.println(str);
    }

    /**
     * Step4. 簡單說就是：把 s.toUpperCase() 當作是 getValue 內要實作的內容，並且把 "abcd" 當作參數傳進去做轉換
     */
    @Test
    public void test3ReplaceLambda() {
        String str = handleString((s) -> s.toUpperCase(), "abcd");
        System.out.println(str);
    }
}
