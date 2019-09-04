package com.michael.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * cas 创建单例模式
 */
public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton(){ }

    public static final CASSingleton getInstance(){
        for (;;) {
            CASSingleton current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            // 开始创建实例
            current = new CASSingleton();
            // 只有当 INSTANCE 的是为 null 时，current 才会被设置，
            // 如果已经被设置了，即当前值 != null，所以不会创建新值
            if (INSTANCE.compareAndSet(null, current)) { // 如果 reference 里面的值 == null, 则更新为 current;
                return current;
            }
        }
    }

    public static void main(String[] args) {
        CASSingleton singleton1 = CASSingleton.getInstance();
        CASSingleton singleton2 = CASSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }









}

