package com.company;


import java.util.concurrent.Callable;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadLocal <String> local = new ThreadLocal<>();
        local.set("nihao");
        local.get();
        Callable callable = new Callable() {//有返回值的任务
            @Override
            public Object call() throws Exception {
                return "null";
            }
        };
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始执行");
                try {
                    for (int i = 0; i < 3; i++) {
                        if (!Thread.interrupted()){
                            System.out.println("i = "+i);
                            Thread.sleep(1000);
                            throw new InterruptedException();
                        }
                        System.out.println("yixie");
                    }
                    }catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println("线程执行完毕");
            }
        });
        thread.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
