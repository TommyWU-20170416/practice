package org.designpattern.factory.practice2;

import org.designpattern.factory.practice1.Pizza;

public class WallyPizza2 {

    /**
     * 呼叫工廠，輸出 pizza
     */
    static SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();

    public static Pizza order(String type) {
        Pizza pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
//        pizza.box();
//        pizza.delivery();
        return pizza;
    }
}
