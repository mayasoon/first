package com.company.threadnotify.product;

public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c= new C(lock);
        ThreadP threadP = new ThreadP(p);
        threadP.setName("threadP");
        ThreadC threadC = new ThreadC(c);
        threadC.setName("threadC");
        threadP.start();
        threadC.start();

    }
}
