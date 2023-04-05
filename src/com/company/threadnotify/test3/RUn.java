package com.company.threadnotify.test3;

import com.company.threadnotify.MyList;

public class RUn {
    public static void main(String[] args) {
        Object lock = new Object();
        MyList myList = new MyList();

        ThreadA a = new ThreadA(lock,myList);
        a.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadB b = new ThreadB(lock,myList);
        b.start();

    }
}
