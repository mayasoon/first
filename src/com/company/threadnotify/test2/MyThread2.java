package com.company.threadnotify.test2;

public class MyThread2 extends Thread{

    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){//获取当前对象锁，
            System.out.println(Thread.currentThread().getName()+" 开始 wait time= "+System.currentTimeMillis());
            lock.notify();
            System.out.println(Thread.currentThread().getName() +" 结束 wait time= "+System.currentTimeMillis());
        }

    }
}
