package com.company.ds;

/**
 * @author meng
 * @Data 2022/10/22 17:58
 * @Desc
 */
public class EggDecorator extends AbstractDecorator{

    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public void doSomeThing() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc()+" 加一个鸡蛋 ";
    }

    @Override
    protected int cost() {
        return super.cost()+1;
    }
}
