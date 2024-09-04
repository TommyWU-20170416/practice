package org.designpattern.strategy;

public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performStrategy() {
        strategy.execute();
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.performStrategy();
        context.setStrategy(new ConcreteStrategyB());
        context.performStrategy();
    }
}
