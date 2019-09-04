package com.michael.singleton;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * // TODO 另外还有通过 cas 生成，静态内部类，枚举等方式生成单例
 *  在高并发的场景下如何保证获取到的是同一个对象
 */
public class Main {


    /**
     * 没有饿汉并发问题
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testEagerSingleton() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
           executorService.execute(() -> {
               System.out.println(EagerSingleton.getInstance().toString());
           });
        }
        executorService.shutdown();
    }

    /**
     * 懒汉模式在没有做并发处理的情况下会发生并发问题
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testLazySingletonNoSync() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        /**
         * 异步方法
         */
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(LazySingleton.getInstanceNoSync().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * 懒汉模式已经做了并发处理
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testLazySingleton() throws ExecutionException, InterruptedException {
        /**
         * 同步方法
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                try {
                    LazySingleton.getInstance();
//                    System.out.println(LazySingleton.getInstance().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }


    public static void testDcl() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                DCL dcl = DCL.getInstance();
                System.out.println(dcl.toString());
            });
        }
        executorService.shutdown();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        testEagerSingleton();

//        testLazySingleton();

//        testLazySingletonNoSync();

        testDcl();

    }

}
