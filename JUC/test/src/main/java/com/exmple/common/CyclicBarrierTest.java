package com.exmple.common;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 10:43
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        // 集齐七颗龙珠召唤神龙

        // 召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("召唤神龙成功！"));

        for (int i = 1; i <= 7; i++) {
           final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + temp + "个龙珠");
                try {
                    cyclicBarrier.await();      // 等待
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
