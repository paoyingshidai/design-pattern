package com.michael.designpattern.command;

import com.michael.designpattern.command.impl.MyCommand;

/**
 * https://www.mekau.com/3439.html
 * https://blog.csdn.net/chunqiuwei/article/details/79030816
 * @auth Michael
 */
public class Main {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);

        Invoker invoker = new Invoker();
        invoker.action(cmd);
    }
}
