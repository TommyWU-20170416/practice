public class HelloJNI {
    static {
        System.load("D:/Class/lab/practice/libHelloJNI.dll");
    }

    public native void sayHello();

    public static void main(String[] args) {
        HelloJNI hello = new HelloJNI();
        hello.sayHello();
    }
}