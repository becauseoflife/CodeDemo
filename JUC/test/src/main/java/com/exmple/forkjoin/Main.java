package com.exmple.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @desc 3000   6000(ForkJoin)    9000(Stream)
 * @auth llp
 * @date 2022年01月27日 15:59
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // test1();    // 333
        // test2();    // 198
        test3();       // 157
    }

    // 普通程序员
    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 1; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间: " + (end-start));
    }

    // 会使用 ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);  // 提交任务
        long sum = submit.get();    // 阻塞等待

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间: " + (end-start));
    }

    // Stream 并行流
    public static void test3(){
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间: " + (end-start));
    }
}
