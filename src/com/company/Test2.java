package com.company;

/**
 * @author meng
 * @Data 2025/4/16 15:33
 * @Desc 交替打印数字，奇数和偶数
 */
public class Test2 {
    static final Object lock = new Object();

    static int number = 0;

    Thread t1 = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    printNumber(++number);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });
    Thread t2 = new Thread(() -> {
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                    printNumber(++number);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    public static void printNumber(int i) {
        System.out.println(i + "----" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.t1.setName("T1111111111111");
        t.t1.start();
        t.t2.setName("T2");
        t.t2.start();

    }
}
