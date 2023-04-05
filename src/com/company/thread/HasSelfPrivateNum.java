package com.company.thread;

public class HasSelfPrivateNum {
    int num = 0;
    public synchronized void add(String username){
        if (username.equals("a")){
            num = 100;
            System.out.println("a set over");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            num = 200;
            System.out.println("b set over");
        }
        System.out.println(username+ " num =  " +num);

    }
}
