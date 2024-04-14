package org.designpattern.decorator.practice1.condiment;

import org.designpattern.decorator.practice1.abstractclass.Beverage;
import org.designpattern.decorator.practice1.abstractclass.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
