package org.designpattern.strategy;

public class ConcreteStrategyA implements Strategy{

    @Override
    public void execute() {
        System.out.println("ConcreteStrategyA.execute()");
    }
}
