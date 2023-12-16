package org.interview;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

interface ClothFactory {
    void produceCloth();
}

/** 代理工廠 */
class ProxyClothFactory implements ClothFactory {
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        factory.produceCloth();
        System.out.println("代理工廠開工");
        System.out.println("代理工廠做完");
    }
}

/** 原廠 */
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("原廠要做東西");
    }
}


public class practice1 {
    public static void main(String[] args) {

        // 2.9
        String str1 = new String("123");
        System.out.println(ReflectionToStringBuilder.toString(str1));

        // 2.12 == 和 equals 區別
        // byte、short、int、long、double、float、char、boolean
        // byte 和 short

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));

        Integer s1 = 1;
        Short s2 = 1;
        System.out.println(s1.equals(s2));

        // 原廠 要做東西
        ClothFactory nike = new NikeClothFactory();
        ClothFactory proxy = new ProxyClothFactory(nike);

        proxy.produceCloth();
    }
}
