package com.michael.proxy.mybatis.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 用於註冊 拦截器，以及调用interceptor.plugin()
 * @author Michael
 *
 */
public class InterceptorChains {

	private final List<Interceptor> interceptors = new ArrayList<>();

    public Object pluginAll(Object target) {
       for (Interceptor interceptor : interceptors) {
         target = interceptor.plugin(target);
       }
       return target;
    }

    public void addInterceptor(Interceptor interceptor) {
       interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors() {
       return Collections.unmodifiableList(interceptors);
    }

}
