package com.michael.strategy.lambda;

/**
 *
 * java 8 之后可以使用 函数式编程来简化策略模式
 *
 */
public class Main {

    public static void main(String[] args) {

        Context context = new Context((a, b) -> a + b);
        System.out.println(context.handler(1, 2));
    }

}
