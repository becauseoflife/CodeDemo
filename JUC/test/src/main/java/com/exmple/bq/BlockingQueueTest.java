package com.exmple.bq;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 14:29
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // test1();
        // test2();
        // test3();
        test4();
    }

    /**
     * @desc 抛出异常
     * @auth llp
     * @date 2022/1/26 14:56
     */
    public static void test1(){
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // IllegalStateException: Queue full : 抛出异常！
        // System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());    // 返回队首元素

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException: 抛出异常
        System.out.println(blockingQueue.remove());
    }

    /**
     * @desc 有返回值
     * @auth llp
     * @date 2022/1/26 15:05
     */
    public static void test2(){
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 不抛出异常，返回 false
        // System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());   // 返回队首元素

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 不抛出异常，返回 null
        System.out.println(blockingQueue.poll());
    }

    /**
     * @desc 阻塞等待
     * @auth llp
     * @date 2022/1/26 15:08
     */
    public static void test3() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);


        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // blockingQueue.put("d");  // 一直阻塞

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());   // 一直阻塞
    }

    /**
     * @desc 超时等待
     * @auth llp
     * @date 2022/1/26 15:08
     */
    public static void test4() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d", 2, TimeUnit.SECONDS);  // 等待2秒则退出

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }
}
