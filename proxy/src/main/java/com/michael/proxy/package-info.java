/**
 * 静态代理
 * 
 * 典型的例子就是 spring security 中的 authenticateProvider 的执行流程
 * 
 * 
 * 动态代理类与静态代理类的区别是：
 * 
 * 1、动态代理类不需要逐个实现 被代理的接口方法，而是可以统一实现，
 * 	  动态代理还可以实现不同类型的接口，不需要指定具体的接口，这说明
 *   他的实用性更强
 * 2、静态代理可以更细粒度的实现接口的方法
 * 
 */
/**
 * @author Michael
 *
 */
package com.michael.proxy;