package org.interview.override;

public class ConstructorOverride {
    ConstructorOverride() {
        System.out.println("我是構造器");
    }

    public static void main(String[] args) {
        SubConstructorOverride subConstructorOverride = new SubConstructorOverride();
    }
}


class SubConstructorOverride extends ConstructorOverride {
    /**
     * Override 不支援 constructor
     * 若可以重寫構造器，則子類也需要有一樣的構造器方法，子類的名稱也要跟構造器同名
     * 基本上就等於是在新建相同的父類了
     * 因此做不到構造器的重寫
     */
    @Override
    ConstructorOverride() {
        System.out.println("我是子類重寫 父類 構造器");
    }

}