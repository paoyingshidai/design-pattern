package com.michael.strategy.lambda;

import java.util.function.BiFunction;

public class Context {

    private BiFunction<Integer, Integer, Integer> strategy;

    public Context(BiFunction<Integer, Integer, Integer> strategy) {
        this.strategy = strategy;
    }

    public Integer handler(Integer a, Integer b) {
        return strategy.apply(a, b);
    }
}
