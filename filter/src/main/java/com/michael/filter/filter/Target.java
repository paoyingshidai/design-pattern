package com.michael.filter.filter;

/**
 * 通过所有的 filter 后，用于最终处理请求的类。
 */
public class Target {
   public void execute(String request){
      System.out.println("Executing request: " + request);
   }
}
