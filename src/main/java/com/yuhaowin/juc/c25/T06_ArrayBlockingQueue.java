package com.yuhaowin.juc.c25;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            queue.put("a" + i);
        }

        //strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa");
        System.out.println(queue.offer("aaa"));
        //strs.offer("aaa", 1, TimeUnit.SECONDS);

        System.out.println(queue);
    }
}
