package com.exmple.function;

import java.util.function.Supplier;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 17:06
 */
public class Demo04 {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                System.out.println("get()");
//                return "1024";
//            }
//        };

        Supplier<String> supplier = () -> { return "1024"; };

        System.out.println(supplier.get());
    }
}
