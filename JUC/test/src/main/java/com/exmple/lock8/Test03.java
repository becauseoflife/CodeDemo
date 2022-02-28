package com.exmple.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月24日 15:57
 * 5、增加两个静态同步方法，只有一个对象，先打印发短信还是打电话？
 * 6、增加两个静态同步方法，两个对象，先打印发短信还是打电话？
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        // 两个对象
        Phone03 phone1 = new Phone03();
        Phone03 phone2 = new Phone03();

        new Thread(()->{
            phone1.sendSms();
        }, "线程A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone2.call();
        }, "线程B").start();
    }
}

class Phone03{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("Hello");
    }
}

