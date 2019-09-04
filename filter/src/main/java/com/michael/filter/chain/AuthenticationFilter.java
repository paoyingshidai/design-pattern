package com.michael.filter.chain;

public class AuthenticationFilter implements Filter {
	
	public void execute(String request, FilterChain chain) {
		System.out.println("Authenticating request: " + request);
		chain.execute(request);
	}
}
