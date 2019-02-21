package com.michael.filter.filter;

public class Client {

	FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		// 如果没有代理, 将会执行 Target.execute();

		filterManager.filterRequest(request);
	}
}
