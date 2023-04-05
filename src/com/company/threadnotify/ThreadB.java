package com.company.threadnotify;

public class ThreadB extends Thread{
    MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);//让出CPU资源，下次从新从主内存当中拉取myList的长度，没有这句话不会线程B永远不会停止

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (myList.size()==5){
                System.out.println(Thread.currentThread().getName()+ " ==5 B 退出");
                break;
            }
        }
    }
}
