package org.designpattern.decorator.practice1.coffee;

import org.designpattern.decorator.practice1.abstractclass.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }
    @Override
    public double cost() {
        return .59;
    }
}
