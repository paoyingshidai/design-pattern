package com.michael.singleton;

/**
 *
 * 使用静态内部类实现线程安全的单例模式
 *
 * Java 内部类和静态内部类的加载时机 https://blog.csdn.net/OOC_ZC/article/details/84584896
 * 内部类和静态内部类都是延时加载的，也就是说只有在明确用到内部类时才加载。只使用外部类时不加载。
 *
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。
 *
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，
 * 在类进行初始化时，别的线程是无法进入的。
 *
 * 优点：避免了线程不安全，延迟加载，效率高。
 *
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
