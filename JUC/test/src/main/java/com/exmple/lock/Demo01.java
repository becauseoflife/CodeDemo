package com.exmple.lock;

/**
 * @desc
 * @auth llp
 * @date 2022年01月28日 14:42
 */
public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(phone::send, "A").start();

        new Thread(phone::send, "B").start();
    }
}


class Phone{

    public synchronized void send(){
        System.out.println(Thread.currentThread().getName() + "send");
        call(); // 这里有锁
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName() + "call");
    }
}
