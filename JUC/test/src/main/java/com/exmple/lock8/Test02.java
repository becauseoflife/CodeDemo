package com.exmple.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月24日 15:19
 * 3、增加了一个普通方法后，先执行发短信还是hello  -- 普通方法
 * 4、两个对象，两个同步方法，两个线程是先打印发短信还是打电话？  -- 1/打电话 2/发短信
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        // 两个对象
        Phone02 phone1 = new Phone02();
        Phone02 phone2 = new Phone02();

        new Thread(phone1::sendSms, "线程A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(phone2::call, "线程B").start();
    }
}

class Phone02{
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

    public void hello(){
        System.out.println("Hello");
    }
}
