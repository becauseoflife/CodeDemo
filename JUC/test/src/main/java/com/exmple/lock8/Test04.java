package com.exmple.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月24日 16:06
 * 7、一个普通同步方法和一个静态同步方法，一个对象，先打印发短信还是打电话？ --
 * 8、一个普通同步方法和一个静态同步方法，两个个对象，先打印发短信还是打电话？ --
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        // 两个对象
        Phone04 phone1 = new Phone04();
        Phone04 phone2 = new Phone04();

        new Thread(()->{
            phone1.sendSms();
        }, "线程A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            phone2.call();
        }, "线程B").start();
    }
}

class Phone04{
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("Hello");
    }
}
