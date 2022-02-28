package com.exmple.function;

import java.util.function.Function;

/**
 * @desc
 * @auth llp
 * @date 2022年01月26日 16:43
 */
public class Demo01 {
    public static void main(String[] args) {
        // 工具类，输出输入的值
//        Function function = new Function<String, String>() {
//            @Override
//            public String apply(String o) {
//                return o;
//            }
//        };
        Function function = (Function<String, String>) o -> o;

//      Function<String, String> function = (str)->{return str;};

        System.out.println(function.apply("test"));
    }
}
