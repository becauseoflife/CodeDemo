package com.exmple.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @desc
 * @auth llp
 * @date 2022年01月25日 11:08
 */
public class SetTest {
    public static void main(String[] args) {
        // Set<String> set = new HashSet<>();
        /**
         * 解决方法：
         * 1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
         * 2、Set<String> set = new CopyOnWriteArraySet<>();
         *
         */
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
