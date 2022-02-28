package com.exmple.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc
 * @auth llp
 * @date 2022年01月25日 11:17
 */
public class MapTest {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        /**
         * 解决办法：
         * 1、Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
         * 2、Map<String, String> map = new ConcurrentHashMap<>();
         */
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
