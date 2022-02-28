package com.exmple.single;

import java.lang.reflect.Constructor;

/**
 * @desc 懒汉式单例模式
 * @auth llp
 * @date 2022年01月28日 9:55
 */
public class LazyMan {

    private static boolean mainbao = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if (mainbao == false){
                mainbao = true;
            }else {
                throw new RuntimeException("不要使用反射破坏异常");
            }
//            if (lazyMan != null){
//                throw new RuntimeException("不要使用反射破坏异常");
//            }
        }
    }

    // 因此这里必须加 volatile 避免指令重排
    private volatile static LazyMan lazyMan;

    // 双重检测锁模式的 懒汉式单例 DCL模式
    public static LazyMan getInstance(){
        if (lazyMan == null){
            synchronized (LazyMan.class){
                if (lazyMan == null){
                    lazyMan = new LazyMan();    // 不是一个原子性操作，有可能发生指令重排
                    // 1、 分配内存空间
                    // 2、 执行构造方法，初始化对象
                    // 3、 把这个对象指向这个空间
                }
            }
        }
        return lazyMan; // 有可能没有完成构造
    }

    // 通过反射破坏
    public static void main(String[] args) throws Exception {
        // LazyMan instance = LazyMan.getInstance();    // 构造器加锁判断抛异常
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        LazyMan instance2 = declaredConstructor.newInstance();  // 都使用反射机制创建，构造器加锁判断也没有用 ==> 使用标志变量

        // System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
