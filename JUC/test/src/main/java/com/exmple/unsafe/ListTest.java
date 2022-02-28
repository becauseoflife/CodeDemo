package com.exmple.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @desc java.util.ConcurrentModificationException 并发修改异常
 * @auth llp
 * @date 2022年01月25日 10:48
 */
public class ListTest {
    public static void main(String[] args) {
        // ArrayList 并发下不安全
        // List<String> list = new ArrayList<>();
        /**
         * 解决方案：
         * 1、List<String> list = new Vector<>();
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、List<String> list = new CopyOnWriteArrayList<>();
         */
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();   // CopyOnWrite 写入时复制 在写入的时候避免覆盖，造成数据问题
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();

        }
    }
}
