package com.company.threadnotify.test2;

public class Test2 {
    public static void main(String[] args) {
        Object lock = new Object();
        try {
            MyThread1 t1 = new MyThread1(lock);
            t1.setName("thread 1 ");
            t1.start();
            Thread.sleep(3000);
            MyThread2 t2 = new MyThread2(lock);
            t2.setName("thread 2 ");
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
