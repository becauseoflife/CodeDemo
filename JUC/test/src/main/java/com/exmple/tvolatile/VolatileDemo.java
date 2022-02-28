package com.exmple.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @desc 不保证原子性
 * @auth llp
 * @date 2022年01月28日 9:24
 */
public class VolatileDemo {

    // volatile 不保证原子性
    // private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        // num++;  // 不是一个原子性操作
        num.getAndIncrement();      // getAndIncrement()  +1 方法
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){   // main GC
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
