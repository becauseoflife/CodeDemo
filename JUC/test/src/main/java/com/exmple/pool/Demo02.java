package com.exmple.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 16:05
 * new ThreadPoolExecutor.AbortPolicy()    // 拒绝策略，如果队列满了，就不处理，抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()       // 哪来的去哪里！
 * new ThreadPoolExecutor.DiscardPolicy()        // 队列满了，丢掉任务，不会抛出异常
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()      // 队列满了，尝试去和最早的竞争，如果竞争成功则执行，否则丢弃。也不会抛弃异常
        );

        // 获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        try {
            // 最大承载： Deque + max 抛出异常== RejectedExecutionException
            for (int i = 1; i <= 10; i++) {
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }
}
