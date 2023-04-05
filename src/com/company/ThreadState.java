package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreadState {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getState());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println(t.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());


    }
}
