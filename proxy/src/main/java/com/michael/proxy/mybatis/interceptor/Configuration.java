package com.michael.proxy.mybatis.interceptor;

import com.michael.proxy.mybatis.interceptor.impl.CacheInterceptor;
import com.michael.proxy.mybatis.interceptor.impl.ExcutorImpl;
import com.michael.proxy.mybatis.interceptor.impl.PageInterceptor;

/**
 * 首先将拦截器注册到 interceptorChains， 然后用 interceptorChains.pluginAll（） 生成代理链 最终执行代理方法
 * 
 * @author Michael
 *
 */
public class Configuration {

	public static void main(String[] args) {
		InterceptorChains interceptorChains = new InterceptorChains();
		interceptorChains.addInterceptor(new PageInterceptor());
		interceptorChains.addInterceptor(new CacheInterceptor());

		Excutor excutor = new ExcutorImpl();

		excutor = (Excutor) interceptorChains.pluginAll(excutor);

		excutor.call("hello");
	}

}
