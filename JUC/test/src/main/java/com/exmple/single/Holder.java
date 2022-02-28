package com.exmple.single;

/**
 * @desc 静态内部类
 * @auth llp
 * @date 2022年01月28日 10:07
 */
public class Holder {

    public Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
