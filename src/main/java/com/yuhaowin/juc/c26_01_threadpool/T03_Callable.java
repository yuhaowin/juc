package com.yuhaowin.juc.c26_01_threadpool;

import java.util.concurrent.*;

/**
 * 认识Callable，对Runnable进行了扩展
 * 对Callable的调用，可以有返回值
 */
public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println("hello test");
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> future = service.submit(c); //异步
        System.out.println(future.get());//阻塞

        service.shutdown();
    }
}
