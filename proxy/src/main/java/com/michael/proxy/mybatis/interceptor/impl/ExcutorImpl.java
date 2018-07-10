package com.michael.proxy.mybatis.interceptor.impl;

import com.michael.proxy.mybatis.interceptor.Excutor;

public class ExcutorImpl implements Excutor {

	@Override
	public void call(String call) {
		System.out.println(call);
	}

}
