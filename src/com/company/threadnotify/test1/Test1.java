package com.company.threadnotify.test1;
//wait后的代码永远不执行
public class Test1 {
    public static void main(String[] args) {

        String lock = new String("");
        System.out.println("sync上面");
        try {
            synchronized (lock){
                System.out.println("sync第一行");
                lock.wait();
                System.out.println("wait下面 一行");
            }
            System.out.println("sync外面 代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
