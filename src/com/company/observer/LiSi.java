package com.company.observer;

/**
 * @author meng
 * @Data 2021/8/13 11:41 下午
 * @Desc
 */
public class LiSi extends Observer{
    public LiSi(Subject subject) {
        subject.attach(this);
    }

    @Override
    public void update(int change) {
        System.out.println("订阅着LiSi发现了改变的通知"+change);
    }
}
