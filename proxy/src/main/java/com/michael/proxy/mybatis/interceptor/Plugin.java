package com.michael.proxy.mybatis.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class Plugin implements InvocationHandler {

	private Object target;
    private Interceptor interceptor;

	 private Plugin(Object target, Interceptor interceptor) {
	    this.target = target;
	    this.interceptor = interceptor;
	  }

	 public static Object wrap(Object target, Interceptor interceptor) {
		 Class<?> type = target.getClass();
		 Class<?>[] interfaces = getAllInterfaces(type);
		 if (interfaces.length > 0) {
			 return Proxy.newProxyInstance(
					 type.getClassLoader(),
					 interfaces,
					 new Plugin(target, interceptor));
		 }
		 return target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return interceptor.intercept(new Invocation(target, method, args));
//        return method.invoke(target, args);
	}



	private static Class<?>[] getAllInterfaces(Class<?> type) {
	    Set<Class<?>> interfaces = new HashSet<Class<?>>();
	    while (type != null) {
	      for (Class<?> c : type.getInterfaces()) {
	          interfaces.add(c);
	      }
	      type = type.getSuperclass();
	    }
	    return interfaces.toArray(new Class<?>[interfaces.size()]);
	  }

}
