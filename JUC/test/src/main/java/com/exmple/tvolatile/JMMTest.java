package com.exmple.tvolatile;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月27日 17:55
 */
public class JMMTest {
    // 不加 volatile 程序就会死循环
    private volatile static int num = 0;
    public static void main(String[] args) {
        new Thread(()->{    // 线程A对主内存的变化不知道
            while (num == 0){

            }
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }
}
