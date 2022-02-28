package com.exmple.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc Lock锁
 * @auth llp
 * @date 2022年01月07日 15:17
 */
public class SaleTicketsDemo02 {
    public static void main(String[] args) {
        Tickets02 tickets02 = new Tickets02();

        // Runnable -> @FunctionalInterface 函数式接口
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets02.sale(); }, "线程A").start();
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets02.sale(); }, "线程B").start();
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets02.sale(); }, "线程C").start();
    }
}


// Lock
class Tickets02{
    // 属性、方法
    private int number = 50;

    Lock lock = new  ReentrantLock();

    // 卖票的方式
    public void sale(){
        // 加锁
        lock.lock();
        try {
            // 业务代码
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票，剩余：" + number + "张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();  // 解锁
        }
    }
}