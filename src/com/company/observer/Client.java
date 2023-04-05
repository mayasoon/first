package com.company.observer;

/**
 * @author meng
 * @Data 2021/8/13 11:24 下午
 * @Desc 观察者模式
 */
public class Client {

    public static void main(String[] args) {
        //创建被订阅主题
        Subject subject = new Subject();
        ZhangSan zhangSan = new ZhangSan(subject);
        LiSi liSi = new LiSi(subject);
        subject.setAnyThing(10);
    }


}
