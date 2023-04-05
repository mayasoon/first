package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CASDemo {
    static int count = 0;
    public static void request() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(5);//模拟耗时操作
        count++;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);//线程结束后执行的操作，等待线程执行完成

    }

}
