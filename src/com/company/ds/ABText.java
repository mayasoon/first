package com.company.ds;

/**
 * @author meng
 * @Data 2022/10/22 18:01
 * @Desc 有一个引用链，一直追溯调用
 */
public class ABText {
    public static void main(String[] args) {
        ABattercake aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);
        System.out.println(aBattercake.getDesc() + "" +aBattercake.cost());


    }

}
