package com.company.threadnotify.product;

public class DeadRun {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        Thread[] pts = new Thread[2];
        Thread[] rts = new Thread[2];
        for (int i = 0; i < 2; i++) {
            pts[i] = new ThreadP(p);
            pts[i].setName("生产者 "+(i+1));
            rts[i] = new ThreadC(c);
            rts[i].setName("消费者 "+(i+1));
            pts[i].start();
            rts[i].start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (Thread thread : threads) {
            System.out.println(thread.getName() + " " + thread.getState());
        }

    }
}
