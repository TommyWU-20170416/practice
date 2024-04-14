package org.designpattern.decorator.practice1.abstractclass;

/**
 * 這是所有飲料的父類別，同時也是調味料的父類別
 * 主要是為了讓調味料也可獲取飲料的父類別
 * 這樣就可以使用相同的物件做組合
 */
public abstract class Beverage {
    public String description = "unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 讓子物件都要實作自己的花費金額
     * @return
     */
    public abstract double cost();
}
