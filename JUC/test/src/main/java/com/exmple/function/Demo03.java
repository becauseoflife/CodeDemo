package com.exmple.function;

import java.util.function.Consumer;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 17:01
 */
public class Demo03 {
    public static void main(String[] args) {
        // 打印字符串
//        Consumer consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer = System.out::println;

        consumer.accept("test");
    }
}
