package org.designpattern.decorator.practice1.abstractclass;

public abstract class CondimentDecorator extends Beverage{

    /**
     * 這邊是重要的物件，在抽象裝飾器內就要有這物件
     * 這個是讓他跟其他繼承 Beverage 最大的不同
     * 一般繼承只會要 繼承後的參數
     * 但這個繼承會把父類存起來，讓他可以做後續新增的行為
     */
    public Beverage beverage;
    public abstract String getDescription();
}
