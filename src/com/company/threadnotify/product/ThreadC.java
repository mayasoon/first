package com.company.threadnotify.product;
//消费线程
public class ThreadC extends Thread{

    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true){

            c.getValue();
        }

    }
}
