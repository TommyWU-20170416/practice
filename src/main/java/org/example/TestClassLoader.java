package org.example;

public class TestClassLoader {
    public static void main(String[] args) {
        TestClassLoader testClassLoader = new TestClassLoader();

        /** 啟動 加載器 */
        System.out.println(testClassLoader.getClass().getClassLoader().getParent().getParent()); // null
        /** 擴展類 加載器 */
        System.out.println(testClassLoader.getClass().getClassLoader().getParent()); // sun.misc.Launcher$ExtClassLoader@6bc7c054
        /** 應用程序 加載器 */
        System.out.println(testClassLoader.getClass().getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

        new Thread().start();
    }
}
