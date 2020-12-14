package com.michael.proxy.cglib.instance;

import lombok.Getter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

abstract public class GameStateContextCglib implements MethodInterceptor  {

    @Getter
    public AbstractGameStateContext target;

    public AbstractGameStateContext getInstance(AbstractGameStateContext target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (AbstractGameStateContext) enhancer.create();
    }

    public AbstractGameStateContext getInstance(AbstractGameStateContext target, Class[] classes, Object[] objects) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (AbstractGameStateContext) enhancer.create(classes, objects);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return doIntercept(obj, method, args, proxy);
    }

    abstract protected Object doIntercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable;

}
