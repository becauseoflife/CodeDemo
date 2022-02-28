package com.exmple.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc Executors 工具类、3大方法
 * @auth llp
 * @date 2022年01月26日 15:44
 */
public class Demo01 {
    public static void main(String[] args) {
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建一个固定的线程池的大小
        ExecutorService threadPool = Executors.newCachedThreadPool();// 可伸缩的,遇强则强，遇弱则弱

        try {
            // 使用了线程池后，要使用线程池创建线程
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }

            // 线程池使用完后要关闭线程池
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
