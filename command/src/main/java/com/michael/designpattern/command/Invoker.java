package com.michael.designpattern.command;

/**
 * @auth Michael
 */
public class Invoker {

    public Invoker() {
    }

    public void action(Command command) {
        command.exe();
    }
}
