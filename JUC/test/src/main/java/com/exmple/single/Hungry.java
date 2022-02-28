package com.exmple.single;

/**
 * @desc 饿汉式单例模式  可能会浪费空间
 * @auth llp
 * @date 2022年01月28日 9:52
 */
public class Hungry {

    // 构造器私有
    private Hungry(){}

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
