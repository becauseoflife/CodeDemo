package com.exmple.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @desc 同步队列 和其他的 BlockingQueue 不一样， SynchronousQueue不存储元素
 * @auth llp
 * @date 2022年01月26日 15:18
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>(); // 同步队列

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);

                System.out.println(Thread.currentThread().getName() + " take "+ synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + " take "+ synchronousQueue.take());
                System.out.println(Thread.currentThread().getName() + " take "+ synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }
}
