package com.michael.filter.chain;

public class DebugFilter implements Filter {
	
	public void execute(String request, FilterChain chain) {
		System.out.println("request log: " + request);
		chain.execute(request);
	}
}
