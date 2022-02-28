package com.exmple.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc
 * @auth llp
 * @date 2022年01月28日 14:45
 */
public class Demo02 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();

        new Thread(phone::send, "A").start();

        new Thread(phone::send, "B").start();
    }
}


class Phone2{
    Lock lock = new ReentrantLock();

    public void send(){
        lock.lock();    // 细节问题：lock-send -> lock-call -> unlock-call -> unlock-send
        try {
            System.out.println(Thread.currentThread().getName() + "send");
            call(); // 这里有锁
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
