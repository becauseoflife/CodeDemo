package com.exmple.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc 基本的卖票例子 线程就是一个单独的资源类，没有任何附属的操作！ 属性和方法
 * @auth llp
 * @date 2022年01月07日 14:26
 */
public class SaleTicketsDemo01 {
    public static void main(String[] args) {
        // 多线程操作
        final Tickets01 tickets = new Tickets01();

        // Runnable -> @FunctionalInterface 函数式接口
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets.sale(); }, "线程A").start();
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets.sale(); }, "线程B").start();
        new Thread( ()->{ for (int i = 0; i < 60; i++) tickets.sale(); }, "线程C").start();
    }
}

// 资源类 OOP
class Tickets01{
    // 属性、方法
    private int number = 50;

    // 卖票的方式
    // public void sale(){
    public synchronized void sale(){
        // 业务代码
        if (number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票，剩余：" + number + "张票");
        }
    }
}
