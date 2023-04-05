package com.company.observer;

/**
 * @author meng
 * @Data 2021/8/13 11:23 下午
 * @Desc 订阅者 不同的实现类，不同的订阅着
 */
public abstract class Observer {
    //订阅的主题
    Subject subject;
    //更新方法
    public abstract void update(int change);
}
