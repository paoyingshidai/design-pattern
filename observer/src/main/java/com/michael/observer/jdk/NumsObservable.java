package com.michael.observer.jdk;

import java.util.Observable;

/**
 * 被观察者 相当于 Subject
 * @author windows
 *
 */
public class NumsObservable extends Observable {

    public final static Integer ODD = 1;
    public final static Integer EVEN = 2;
    private int data = 0;

    public int getData() {
       return data;
    }

    public void setData(int i) {
       data = i;
       Integer flag = EVEN;
       if ((data & 0x0001) == 1)
           flag = ODD;
       setChanged();
       notifyObservers(flag);
    }

}