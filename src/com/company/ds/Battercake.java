package com.company.ds;

/**
 * @author meng
 * @Data 2022/10/22 17:54
 * @Desc 煎饼实现类
 */
public class Battercake extends ABattercake{
    @Override
    protected String getDesc() {
        return " 一个煎饼 ";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
