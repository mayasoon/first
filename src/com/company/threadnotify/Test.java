package com.company.threadnotify;

public class Test {
    //通过不断循环查看共享资源是否就绪，耗费CPU资源严重，需要wait notify 机制改善
    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();
        ThreadB b = new ThreadB(myList);
        b.setName("B");
        b.start();

    }
}
