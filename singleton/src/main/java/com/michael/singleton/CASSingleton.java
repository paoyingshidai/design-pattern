package com.michael.singleton;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * cas 创建单例模式
 */
public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton(){ }

    public static final CASSingleton getInstance(CountDownLatch count){
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (;;) {
            CASSingleton current = INSTANCE.get();  // 这里可能会有多个线程进入到这一步
            if (current != null) {
                return current;
            }
            // 开始创建实例 （可能会有多个线程同时创建实例）
            current = new CASSingleton();
            System.out.println("create");
            // 只有当 INSTANCE 的是为 null 时，current 才会被设置，
            // 如果已经被设置了，即当前值 != null，所以不会创建新值
            if (INSTANCE.compareAndSet(null, current)) {
                // 这里只有一个线程会 set 成功
                // 如果 reference 里面的值 == null, 则更新为 current;
                return current;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch count = new CountDownLatch(1);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                CASSingleton singleton1 = CASSingleton.getInstance(count);
                System.out.println(singleton1);
            });
        }
        TimeUnit.SECONDS.sleep(1);
        count.countDown();
        System.out.println("dont");
        service.shutdown();
    }

}

