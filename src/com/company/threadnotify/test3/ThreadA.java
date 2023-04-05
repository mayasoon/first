package com.company.threadnotify.test3;

import com.company.threadnotify.MyList;

public class ThreadA extends Thread{

    private Object lock;
    private MyList myList;
    public ThreadA(Object lock,MyList myList) {
        this.lock = lock;
        this.myList = myList;
    }

    @Override
    public void run() {
        synchronized (lock){
            if (myList.size()!=5){
                System.out.println(Thread.currentThread().getName()+" wait begin "+System.currentTimeMillis());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" wait end "+System.currentTimeMillis());
            }
        }
    }
}
