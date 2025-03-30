package com.company.threadnotify;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    //通过不断循环查看共享资源是否就绪，耗费CPU资源严重，需要wait notify 机制改善
    public static void main(String[] args) {
//        MyList myList = new MyList();
//        ThreadA threadA = new ThreadA(myList);
//        threadA.setName("A");
//        threadA.start();
//        ThreadB b = new ThreadB(myList);
//        b.setName("B");
//        b.start();
        AtomicInteger s = new AtomicInteger();

        System.out.println(s.incrementAndGet());
        System.out.println(s.incrementAndGet());
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.peek();
    }
}
