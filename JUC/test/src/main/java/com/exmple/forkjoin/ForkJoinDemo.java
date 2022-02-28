package com.exmple.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @desc 求和计算任务
 * @auth llp
 * @date 2022年01月27日 15:26
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private long start;
    private long end;

    // 临界值
    private long temp = 10000L;


    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            // ForkJoin 递归
            long mid = (end + start) / 2;   // 中间值
            ForkJoinDemo forkJoinTask1 = new ForkJoinDemo(start, mid);
            forkJoinTask1.fork();       // 拆分任务，把任务任务压入线程队列
            ForkJoinDemo forkJoinTask2 = new ForkJoinDemo(mid+1, end);
            forkJoinTask2.fork();       // 拆分任务，把任务任务压入线程队列

            return forkJoinTask1.join() + forkJoinTask2.join();
        }
    }
}
