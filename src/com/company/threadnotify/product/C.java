package com.company.threadnotify.product;
//消费者C customer
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        synchronized (lock){
            if (ValueObject.value.equals("")){
                try {
                    System.out.println(Thread.currentThread().getName()+" wait");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+" wait 被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" get 值 =  "+ValueObject.value);
            ValueObject.value = "";
            lock.notify();
            System.out.println(Thread.currentThread().getName()+" notify");

        }
    }

}
