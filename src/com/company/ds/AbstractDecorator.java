package com.company.ds;/**
 * @author meng
 * @Data 2022/10/22 17:55
 * @Desc 煎饼装饰类,加入了自己的一些方法
 */
public abstract class AbstractDecorator extends ABattercake{
    ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    public abstract void doSomeThing();

    @Override
    protected String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return aBattercake.cost();
    }
}
