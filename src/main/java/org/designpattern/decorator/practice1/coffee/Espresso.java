package org.designpattern.decorator.practice1.coffee;

import org.designpattern.decorator.practice1.abstractclass.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }
    @Override
    public double cost() {
        return .99;
    }
}
