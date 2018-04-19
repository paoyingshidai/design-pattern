package com.michael.filter.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	
	private List<Filter> filters = new ArrayList<Filter>();
	private int currentPosition = 0;
	private int size = 0;
	
	private Target target;

	public void addFilter(Filter filter) {
		filters.add(filter);
		this.size++;
	}

	public void execute(String request) {
		
		if (currentPosition == size) {
			target.execute(request);	
		} else {
			currentPosition ++;
			Filter filter  = filters.get(currentPosition - 1);
			filter.execute(request, this);
		}
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
