package org.interview.passbyvalue;

class MyClass {
    int value;

    MyClass(int value) {
        this.value = value;
    }
}

public class Example {
    public static void modifyObject(MyClass obj, int newValue) {
        obj.value = newValue;
    }

    public static void modifyValue(int newValue) {
        newValue = 20;
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass(10);
        int originalValue = 10;

        System.out.println("原始值: " + myObject.value + ", " + originalValue);
        modifyObject(myObject, 20);
        modifyValue(originalValue);
        System.out.println("修改後的值: " + myObject.value + ", " + originalValue);
    }
}
