package com.company.threadnotify.test3;

import com.company.threadnotify.MyList;

public class ThreadB extends Thread{

    private Object lock;
    private MyList myList;

    public ThreadB(Object lock, MyList myList) {
        this.lock = lock;
        this.myList = myList;
    }

    @Override
    public void run() {
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                myList.add();
                if (myList.size()==5){
                    lock.notify();
                    System.out.println(Thread.currentThread().getName()+" 已发出通知");
                }
                System.out.println(Thread.currentThread().getName()+" 添加了 "+(i + 1)+"个元素");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
