package cn.sz.lwt.service.impl;

import java.lang.reflect.Method;

import cn.sz.lwt.service.IUserService;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

//Bean工厂,用于生成代理类
public class ProxyFactory {
	
	
	
	public static IUserService creatService() {
		//目标类
		final IUserService uservice = new UserServiceImpl();
		//切面类
		final MyAspect as = new MyAspect();
		//代理类,将目标类(pointCut)和切面类(advice)结合,代理类的每个方法每次执行,都会调用处理类的invoke方法
		IUserService proxyService = (IUserService)Proxy.newProxyInstance(
				ProxyFactory.class.getClassLoader(), 
				uservice.getClass().getInterfaces(), 
				//处理类接口
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//前执行
						//as.before();
						//执行目标类的方法
						Object returnValue = method.invoke(uservice, args);
						//后执行
						//as.after();
						return returnValue;
					}
				});
					
			return proxyService;
	}
}
