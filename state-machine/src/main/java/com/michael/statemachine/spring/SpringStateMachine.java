package com.michael.statemachine.spring;

import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

/**
 * @auth Michael
 */
public class SpringStateMachine {

    public StateMachine<String, String> buildMachine() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .taskExecutor(new SyncTaskExecutor())
                .autoStartup(true);

        builder.configureStates()
                .withStates()
                .initial("SI")
                .state("S1");

        builder.configureTransitions()
                .withExternal()
                .source("SI").target("S1")
                .event("E1")
                .action(c -> {
                    c.getExtendedState().getVariables().put("key1", "value1");
                });

        return builder.build();
    }

    public static void main(String[] args) {



    }

}
