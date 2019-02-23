package com.michael.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Double Check Locking 双检查锁机制（推荐）
 * 为了达到线程安全，又能提高代码执行效率，我们这里可以采用DCL的双检查锁机制来完成，代码实现如下：
 */
public class DCL {

    //使用volatile关键字保其可见性
    volatile private static DCL instance = null;

    private DCL(){}

    //懒汉式, 相比于锁住整个方法，这个模式效率更高
    public static DCL getInstance() {
        long before = System.currentTimeMillis();

        try {
            if(instance != null) {
                TimeUnit.SECONDS.sleep(1);
            } else {
                //创建实例之前可能会有一些准备性的耗时工作
                TimeUnit.SECONDS.sleep(1);
                synchronized (DCL.class) {
                    //二次检查
                    if(instance == null){
                        instance = new DCL();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - before);

        return instance;
    }

}
