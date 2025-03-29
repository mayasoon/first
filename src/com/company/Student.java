package com.company;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
        HashMap hashMap = new HashMap();
        Executors.newScheduledThreadPool(10);

    }

    public int age;
    public String name;
}
