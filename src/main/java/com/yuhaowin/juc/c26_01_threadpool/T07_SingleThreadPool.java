package com.yuhaowin.juc.c26_01_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T07_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            service.execute(() -> {

                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }

    }
}
