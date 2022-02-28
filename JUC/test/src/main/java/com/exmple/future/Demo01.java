package com.exmple.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @desc 异步调用
 * @auth llp
 * @date 2022年01月27日 16:29
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
//        });
//        System.out.println("11111111");
//        completableFuture.get();    // 获取阻塞执行结果

        // 有返回值的异步回调
        // ajax 成功和失败有回调
        // 返回的是错误信息
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync==>Integer");
            // int i = 10/0;
            return 1024;
        });

        Integer res = completableFuture.whenComplete((T, U) -> {
            System.out.println("T=> " + T);     // 返回正常结果
            System.out.println("U=> " + U);     // 返回错误信息： java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e) -> {
            e.getMessage();
            return 233;     // 可以回去到错误的返回结果
        }).get();

        System.out.println("返回结果：" + res);
    }
}
