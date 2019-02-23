package com.michael.singleton;

/**
 *
 * 使用静态内部类实现线程安全的单例模式
 *
 */
public class StaticInnerClass {

    //内部类
    private static class MySingletonHandler{
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    private StaticInnerClass() {}

    public static StaticInnerClass getInstance() {
        return MySingletonHandler.instance;
    }

}
