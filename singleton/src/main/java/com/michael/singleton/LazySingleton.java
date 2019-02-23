package com.michael.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 单例模式-懒汉式单例
 */
public class LazySingleton {

    //私有静态对象,加载时候不做初始化
    private static LazySingleton m_intance = null;

    // 私有构造方法,避免外部创建实例
    private LazySingleton() {}

    /**
     * 静态工厂方法,返回此类的唯一实例.
     * 当发现实例没有初始化的时候,才初始化.
     * @return LazySingleton
     */
    synchronized public static LazySingleton getInstance() throws InterruptedException {
        long before = System.currentTimeMillis();
        if(m_intance == null){
            TimeUnit.SECONDS.sleep(1);
            m_intance = new LazySingleton();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(System.currentTimeMillis() - before);
        return m_intance;
    }


    /**
     * 如果没有上锁
     * @return
     */
    public static LazySingleton getInstanceNoSync() throws InterruptedException {
        if(m_intance == null){
            TimeUnit.SECONDS.sleep(1);
            m_intance = new LazySingleton();
        }
        return m_intance;
    }

}