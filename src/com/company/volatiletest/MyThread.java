package com.company.volatiletest;
//volatile 保证线程间可见行，但不保证原子性，每次获取变量都强制从共享内存中获取值，而不是使用线程私有数据栈中都值
public class MyThread extends Thread{

    volatile public static int count;
    //synchronized 加入和static
    private static void addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count  = "+count);
    }
    @Override
    public void run() {
        addCount();
    }
}
