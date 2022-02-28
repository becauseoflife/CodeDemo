package com.exmple.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc 自旋锁
 * @auth llp
 * @date 2022年01月28日 14:51
 */
public class SpinlockDemo {
    // int 默认值 0
    // Thread 默认值 null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> myLock");

        // 自旋锁
        while (!atomicReference.compareAndSet(null, thread)){

        }
    }

    // 解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> myUnlock");
        atomicReference.compareAndSet(thread, null);
    }
}

class Test{
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();

        SpinlockDemo spinlockDemo = new SpinlockDemo();

        new Thread(()->{
            spinlockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinlockDemo.myUnlock();
            }
        }, "T1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            spinlockDemo.myLock();      // T2进去，锁被T1获得，只能自旋等待T1释放锁
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinlockDemo.myUnlock();
            }
        }, "T2").start();

    }
}

