package com.company.enumsingleton;

public class Run {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(MyObject.MY_INSTANCE.doSomeThing());
            }).start();
        }

    }
}
