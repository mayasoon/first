package com.company.threadnotify.test2;

public class MyThread1 extends Thread{

    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+" 开始 wait time= "+System.currentTimeMillis());
            //释放当前对象锁 ，，//wait和notify必须线获取对象锁才能执行wait和notify方法
            lock.wait();
            System.out.println(Thread.currentThread().getName()+" 结束 wait time= "+System.currentTimeMillis());
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
