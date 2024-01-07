package org.interview.methodreference;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodReferenceDemo1 {
    public static void main(String[] args) {
        // 對象::實例方法
        // 預期無參數與一個返回，所以用 Supplier
        String str = "Hello, World!";
        Supplier<Integer> lengthFunction = str::length;
        int length = lengthFunction.get();

        System.out.println("Length of the string: " + length);

        // 類::靜態方法
        // 預期兩個參數與一個返回，所以用 BiFunction
        BiFunction<Integer, Integer, Integer> addFunction = MathUtils::add;
        int result = addFunction.apply(5, 3);
        System.out.println("Result of addition: " + result);

        // 類::實例方法
        // 預期一個參數無返回，所以用 Consumer
        Consumer<String> myConsumer = new MyClass()::myInstanceMethod;
        myConsumer.accept("Hello from MyClass");
    }
}

class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}

// 假設有一個類型的任意對象
class MyClass {
    public void myInstanceMethod(String message) {
        System.out.println("MyInstanceMethod: " + message);
    }
}


