package com.exmple.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc Condition 精准通知 A执行完调用B B执行完执行C C执行完执行A
 * @auth llp
 * @date 2022年01月24日 14:47
 */
public class Test03 {
    public static void main(String[] args) {
        Data03 data03 = new Data03();
        new Thread( ()->{
            for (int i = 0; i < 10; i++) data03.printA();
        }, "线程A").start();
        new Thread( ()->{
            for (int i = 0; i < 10; i++) data03.printB();
        }, "线程B").start();
        new Thread( ()->{
            for (int i = 0; i < 10; i++) data03.printC();
        }, "线程C").start();
    }
}

/**
 * @desc 资源类
 * @auth llp
 * @date 2022/1/24 14:48
 */
class Data03{
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();
    private int number = 1; // 1A 2B 3C

    public void printA(){
        lock.lock();
        try {
            // 业务 判断等待 执行 通知
            while (number != 1){
                // 等待
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> 执行打印");
            // 唤醒，唤醒指定的人
            number = 2;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            // 业务 判断等待 执行 通知
            while (number != 2){
                // 等待
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> 执行打印");
            // 唤醒，唤醒指定的人
            number = 3;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            // 业务 判断等待 执行 通知
            while (number != 3){
                // 等待
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> 执行打印");
            // 唤醒，唤醒指定的人
            number = 1;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

