package com.company.deadlock;
//死锁问题
public class DeadThread implements Runnable{
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();
    public void setFlag(String username){
        this.username = username;
    }
    @Override
    public void run() {
        if (username.equals("a")){
            synchronized (lock1){
                System.out.println("username  = "+username);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaaaaaaa");
                //这里线程1需要线程2的lock2的锁 互相等待对方释放锁就有可能出现死锁
                synchronized (lock2){
                    System.out.println("按lock1-->lock2代码顺序执行了");
                }
            }
        }
        if (username.equals("b")){
            synchronized (lock2){
                System.out.println("username  = "+username);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("bbbbbbb");
                //这里线程2需要线程1的lock1的锁
                synchronized (lock1){
                    System.out.println("按lock2-->lock1代码顺序执行了");
                }
            }
        }
    }
}
