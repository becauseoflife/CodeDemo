package com.exmple.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 11:08
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        //MyCache myCache = new MyCache();
        MyCacheLock myCacheLock = new MyCacheLock();

        // 写入
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                //myCache.put(temp+"", temp);
                myCacheLock.put(temp+"", temp);
            }, String.valueOf(i)).start();
        }

        // 读取
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(()->{
                //myCache.get(temp+"");
                myCacheLock.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * @desc 自定义缓存
 * @auth llp
 * @date 2022/1/26 11:08
 */
class MyCache{
    private volatile Map<String, Object> map = new HashMap<>();

    // 存， 写
    public void put(String key, int value){
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入成功！");
    }

    // 取， 读
    public void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取成功！");
    }
}

/**
 * @desc 自定义缓存 加锁
 * @auth llp
 * @date 2022/1/26 11:08
 */
class MyCacheLock{
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 存， 写入的时候，只希望只有一个线程写
    public void put(String key, int value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入成功！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 取， 读，所有人都可以读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取成功！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}