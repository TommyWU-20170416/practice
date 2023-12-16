package org.example;

public class JavaNativeInterfaceExample {

    static {
        System.loadLibrary("NativeLibrary");
    }

    public native void callNativeMethod();

    public static void main(String[] args) {
        JavaNativeInterfaceExample example = new JavaNativeInterfaceExample();
        example.callNativeMethod();
    }
}
