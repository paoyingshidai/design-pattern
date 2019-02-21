package com.michael.filter.chain;

/**
 * FilterChain 的门面类，用于处理 FilterChain 与外部类的数据交互
 * 包括 设置 filter 和 目标类
 */
public class FilterManager {

	final FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}
}
