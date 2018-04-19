package com.michael.filter.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	
	private List<Filter> filters = new ArrayList<Filter>();
	
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	//doFilter
	public void execute(String request) {
		for (Filter filter : filters) {
			filter.execute(request);
			// filter.execute(request, this); 类似于 servlet 的 doFilter
		}
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
