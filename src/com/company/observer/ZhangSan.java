package com.company.observer;

/**
 * @author meng
 * @Data 2021/8/13 11:39 下午
 * @Desc
 */
public class ZhangSan extends Observer{

    public ZhangSan(Subject subject) {
        subject.attach(this);
    }

    @Override
    public void update(int change) {
        System.out.println("订阅着ZhangSan发现了变化"+change);
    }
}
