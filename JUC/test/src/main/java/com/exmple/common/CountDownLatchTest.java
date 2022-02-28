package com.exmple.common;

import java.util.concurrent.CountDownLatch;

/**
 * @desc 计算类
 * @auth llp
 * @date 2022年01月26日 10:36
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 初始化总数, 必须要执行任务的时候，再使用
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "走出了教室!");
                latch.countDown();      // 数量 -1
            }, String.valueOf(i)).start();
        }

        // 等待计数器归零，然后再向下执行
        latch.await();

        System.out.println("关门");
    }
}
