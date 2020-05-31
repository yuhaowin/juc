package com.yuhaowin.juc.c26_00_interview.A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * 要求用线程顺序打印A1B2C3....Z26
 * <p>
 * LockSupport park 当前线程阻塞（停止）
 * LockSupport unpark(Thread t)
 */
public class T02_00_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) throws Exception {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {

            for (char c : aI) {
                System.out.print(c);
                LockSupport.unpark(t2); //叫醒T2
                LockSupport.park();     //T1阻塞
            }

        }, "t1");

        t2 = new Thread(() -> {

            for (char c : aC) {
                LockSupport.park();     //t2阻塞
                System.out.print(c);
                LockSupport.unpark(t1); //叫醒t1
            }

        }, "t2");

        t1.start();
        t2.start();
    }
}


