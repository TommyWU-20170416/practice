package org.designpattern.decorator.practice1.coffee;

import org.designpattern.decorator.practice1.abstractclass.Beverage;

/**
 * HouseBlend 代表著豆子的品質很好、經過適當的烘焙，具有特色風味的配方
 * => 一家店的招牌咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        description = "House Blend Coffee";
    }
    @Override
    public double cost() {
        return .89;
    }
}
