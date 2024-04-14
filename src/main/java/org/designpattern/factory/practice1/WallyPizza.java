package org.designpattern.factory.practice1;

public class WallyPizza {
    public static Pizza order(String type) {
        Pizza pizza = new Pizza();
        /**
         * 決定要做哪一種的 pizza，
         */
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
//        ... 依據有多少口味，決定要實作口味

        /**
         * 這邊是所有 pizza 都會呼叫的工作內容
         */
        pizza.prepare();
//        pizza.box();
//        pizza.delivery();
        return pizza;
    }
}

/**
 * 起士漢堡 子類實作
 */
class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("prepare cheese");
    }
    // 繼續實作各自要使用的方法 ...
}

/**
 * 義大利香腸漢堡 子類實作
 */
class PepperoniPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("prepare pepperoni");
    }
    // 繼續實作各自要使用的方法 ...
}