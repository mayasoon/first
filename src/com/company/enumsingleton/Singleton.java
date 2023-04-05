package com.company.enumsingleton;

/**
 * @author meng
 * @Data 2022/11/14 20:37
 * @Desc
 */
public class Singleton {

    /**
     * volatile 防止指令重排序
     * 1。分配对象内存空间
     * 2。初始化对象
     * 3。设置初始化的对象指向分配的内存地址
     * 如果重排序导致3在2之前，第二个线程进入会拿到null，实例还没有初始化
     */
    private volatile static Singleton instance;

    private Singleton() {//防止外部new 出对象
    }

    public Singleton getInstance(){
        if (instance==null){//第一个验证，当初始化之后其他线程直接拿到单例，不用每次都去取锁，提高性能
            synchronized (Singleton.class){
                if (instance==null){//拿到锁之后去判断是否已经初始化次实例
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
