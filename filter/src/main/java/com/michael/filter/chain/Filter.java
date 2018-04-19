package com.michael.filter.chain;

public interface Filter {

	public void execute(String request, FilterChain chain);
	
//	public void execute(String request, FilterChain chain);

}
