package com.company.threadnotify.product;

import java.util.concurrent.TimeUnit;

//生产者 producer
public class P {
    private String lock;
    private int count;
    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        synchronized (lock){
            if (!ValueObject.value.equals("")){
                try {
                    System.out.println(Thread.currentThread().getName()+" wait");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+" wait 被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = "产品"+(count++);
            //模拟生产耗时
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" set 的值 = "+ value);
            ValueObject.value = value;
            lock.notify();
            System.out.println(Thread.currentThread().getName()+" notify");

        }
    }

}
