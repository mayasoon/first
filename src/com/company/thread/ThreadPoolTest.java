package com.company.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author meng
 * @Data 2025/3/30 17:35
 * @Desc
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(() -> System.out.println("run 1"));
        System.out.println("main - " + Thread.currentThread().getName());
    }
}
