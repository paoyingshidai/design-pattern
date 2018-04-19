package com.michael.filter.filter;

public class DebugFilter implements Filter {
	public void execute(String request) {
		System.out.println("request log: " + request);
	}
	
//	public void execute(String request, FilterChain chain) {
//		System.out.println("request log: " + request);
//		chain.doFilter(request, chain)
//	}
}
