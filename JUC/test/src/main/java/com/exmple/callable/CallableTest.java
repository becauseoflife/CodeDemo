package com.exmple.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 9:54
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable()).start();
        // new Thread(new FutureTask(Callable<V> callable)).start();

        MyThread myThread = new MyThread();
        // 适配类
        FutureTask<String> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask, "线程A").start();
        new Thread(futureTask, "线程B").start();
        // 返回值
        String s = futureTask.get();
        System.out.println(s);

    }
}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "test";
    }
}