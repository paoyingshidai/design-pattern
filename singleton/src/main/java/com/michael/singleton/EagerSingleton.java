package com.michael.singleton;

/**
 * 单例模式-饿汉式单例
 */
public class EagerSingleton {
    /**
     * 私有的(private)唯一(static final)实例成员,在类加载的时候就创建好了单例对象
     */
    private static final EagerSingleton m_instance = new EagerSingleton();

    /**
     * 私有构造方法,避免外部创建实例
     */
    private EagerSingleton() {  }

    /**
     * 静态工厂方法,返回此类的唯一实例.
     * @return EagerSingleton
     */
    public static EagerSingleton getInstance() {
        return m_instance;
    }
}
