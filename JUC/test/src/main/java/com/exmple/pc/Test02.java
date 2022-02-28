package com.exmple.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc
 * @auth llp
 * @date 2022年01月24日 14:20
 */
public class Test02 {
    public static void main(String[] args) {
        Data02 data = new Data02();
        // Runnable -> @FunctionalInterface 函数式接口
        new Thread( ()->{
            for (int i = 0; i < 60; i++) data.increment();
        }, "线程A").start();
        new Thread( ()->{
                for (int i = 0; i < 60; i++) data.decrement();
        }, "线程B").start();
        new Thread( ()->{
            for (int i = 0; i < 60; i++) data.increment();
        }, "线程C").start();
        new Thread( ()->{
            for (int i = 0; i < 60; i++) data.decrement();
        }, "线程D").start();
    }
}

// 判断等待 业务 通知
class Data02{     // 数字 资源类
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // +1
    public void increment(){
        lock.lock();
        try {
            // 业务代码
            while (number != 0){
                // 判断等待
                condition.await();
            }
            // 业务
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知 （通知其他线程，我+1完毕）
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    // -1
    public void decrement(){
        lock.lock();
        try {
            // 业务代码
            while (number == 0){
                // 判断等待
                condition.await();
            }
            // 业务
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知 （通知其他线程，我-1完毕）
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
