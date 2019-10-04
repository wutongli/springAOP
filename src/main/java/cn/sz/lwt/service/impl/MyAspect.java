package cn.sz.lwt.service.impl;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//切面类，用于存储通知或增强advice
public class MyAspect implements MethodInterceptor{
/*	public void before() {
		System.out.println("鸡首");
	}
	public void after() {
		System.out.println("牛后");
	}*/
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("鸡首");
		Object object = invocation.proceed();
		System.out.println("牛后");
		return object;
	}
	
}
