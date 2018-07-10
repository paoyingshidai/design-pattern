package com.michael.proxy.mybatis.interceptor.impl;

import java.util.Properties;

import com.michael.proxy.mybatis.interceptor.Interceptor;
import com.michael.proxy.mybatis.interceptor.Invocation;
import com.michael.proxy.mybatis.interceptor.Plugin;

public class CacheInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("cacheInterceptor");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
