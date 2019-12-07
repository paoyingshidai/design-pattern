package com.michael.observer.jdk;

/**
 * 这里将 观察者与被观察者关联起来
 * @author windows
 *
 */
public class Client {

    public static void main(String[] args) {

        // 事件触发者
        NumsObservable number = new NumsObservable();

        // 添加观察者
        number.addObserver(new OddObserver());
        number.addObserver(new EvenObserver());

        number.setData(1);
        number.setData(2);
        number.setData(3);

    }

}
