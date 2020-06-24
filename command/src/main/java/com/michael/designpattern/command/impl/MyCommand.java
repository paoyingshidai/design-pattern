package com.michael.designpattern.command.impl;

import com.michael.designpattern.command.Command;
import com.michael.designpattern.command.Receiver;

/**
 * @auth Michael
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
