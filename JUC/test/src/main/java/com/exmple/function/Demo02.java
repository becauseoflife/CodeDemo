package com.exmple.function;

import java.util.function.Predicate;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 16:54
 */
public class Demo02 {
    public static void main(String[] args) {
        // 判断字符串是否为空
//        Predicate predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test("s"));
        System.out.println(predicate.test(""));
    }
}
