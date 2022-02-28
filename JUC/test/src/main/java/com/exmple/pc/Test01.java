package com.exmple.pc;

/**
 * @desc
 * @auth llp
 * @date 2022年01月18日 16:22
 */
public class Test01 {
    public static void main(String[] args) {
        Data data = new Data();
        // Runnable -> @FunctionalInterface 函数式接口
        new Thread( ()->{
            try {
                for (int i = 0; i < 60; i++) data.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();
        new Thread( ()->{
            try {
                for (int i = 0; i < 60; i++) data.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B").start();
    }
}

// 判断等待 业务 通知
class Data{     // 数字 资源类
    private int number = 0;

    // +1
    public synchronized void increment() throws InterruptedException {
        while (number != 0){
            // 判断等待
            this.wait();
        }
        // 业务
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知 （通知其他线程，我+1完毕）
        this.notifyAll();
    }
    // -1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0){
            // 判断等待
            this.wait();
        }
        // 业务
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知 （通知其他线程，我-1完毕）
        this.notifyAll();
    }
}
