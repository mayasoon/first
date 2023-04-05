package com.company.ds;

/**
 * @author meng
 * @Data 2022/10/22 18:00
 * @Desc
 */
public class SausageDecorator extends AbstractDecorator{


    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    public void doSomeThing() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc()+" 加一个香肠 ";
    }

    @Override
    protected int cost() {
        return super.cost()+2;
    }
}
