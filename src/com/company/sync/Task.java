package com.company.sync;

public class Task {
    public void doLongTimeTask(){
        for (int i = 0; i < 200; i++) {
            System.out.println("no Sync name = "+Thread.currentThread().getName() + "  i  "+(i+1));
        }
        System.out.println("-----");
        synchronized (this){
            for (int i = 0; i < 200; i++) {
                System.out.println("sync name"+Thread.currentThread().getName()+" i = "+(i+1));
            }
        }
    }
}
