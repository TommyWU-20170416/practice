package org.interview.passbyvalue;

class MyClass {
    int value;
    MyClass other;

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

        // 進階的，如果是修改物件內的物件呢
        MyClass my = new MyClass(1);
        MyClass other = new MyClass(2);
        my.other = other;
        modifyMy_null(my);
        System.out.println("my       == null: " + (my == null));
        modifyMyOther_null(my);
        System.out.println("my.other == null: " + (my.other == null));
    }

    private static void modifyMy_null(MyClass my) {
        my = null;
    }
    private static void modifyMyOther_null(MyClass my) {
        my.other = null;
    }
}
