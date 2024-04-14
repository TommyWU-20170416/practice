package org.designpattern.decorator.practice1;

import org.designpattern.decorator.practice1.abstractclass.Beverage;
import org.designpattern.decorator.practice1.coffee.DarkRoast;
import org.designpattern.decorator.practice1.coffee.Espresso;
import org.designpattern.decorator.practice1.coffee.HouseBlend;
import org.designpattern.decorator.practice1.condiment.Mocha;
import org.designpattern.decorator.practice1.condiment.Soy;
import org.designpattern.decorator.practice1.condiment.Whip;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        // 點一杯無調味料的 Espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 點一杯 DarkRoast 加上 雙份Mocha 跟 奶泡
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        // 點一杯 HouseBlend 加上 Soy Mocha Whip
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}
