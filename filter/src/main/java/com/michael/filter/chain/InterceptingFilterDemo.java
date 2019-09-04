package com.michael.filter.chain;

/**
 * 真实的调用是 Client -> Target,
 * 中间添加了 FilterManager 以及 Filter 对整个流程进行调用
 */
public class InterceptingFilterDemo {

	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());

		Client client = new Client();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}
}
