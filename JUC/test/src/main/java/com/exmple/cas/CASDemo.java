package com.exmple.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @desc
 * @auth llp
 * @date 2022年01月28日 10:39
 */
public class CASDemo {
    public static void main(String[] args) {

        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(20, 1);

        new Thread(()->{
            int stamp = stampedReference.getStamp();    // 获得版本号
            System.out.println("A1==>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(stampedReference.compareAndSet(20, 22,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1));

            System.out.println("A2==>" + stampedReference.getStamp());

            System.out.println(stampedReference.compareAndSet(22, 20,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1));

            System.out.println("A2==>" + stampedReference.getStamp());
        }, "A").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();    // 获得版本号
            System.out.println("B1==>" + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(stampedReference.compareAndSet(20, 66, stamp, stamp + 1));

            System.out.println("B2==>" + stampedReference.getStamp());

        }, "B").start();
    }
}
