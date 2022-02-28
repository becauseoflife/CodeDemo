package com.exmple.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月24日 15:19
 * 1、标准情况下，两个线程是先打印发短信还是打电话？  -- 1/发短信 2/打电话
 * 2、sendSms睡4秒，两个线程是先打印发短信还是打电话？  -- 1/发短信 2/打电话
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();

        new Thread(phone::sendSms, "线程A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(phone::call, "线程B").start();
    }
}

class Phone{
    public synchronized void sendSms(){
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
}