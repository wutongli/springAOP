package cn.sz.lwt.service.impl;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.sz.lwt.service.IUserService;

public class CglibFactory {
	public static IUserService creatCglibService() {
		final IUserService service = new UserServiceImpl();
		final MyAspect as = new MyAspect();
		Enhancer eh = new Enhancer();
		//确定父类
		eh.setSuperclass(service.getClass());
		//设置回调函数,等同于invocationHandler
		eh.setCallback(new MethodInterceptor() {
			//拦截器,等同于invocationHandler中的invoke方法
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mehtodproxy) throws Throwable {
				//前方法
				//as.before();
				Object retval = method.invoke(service, args);
				//mehtodproxy.invokeSuper(proxy, args);//代理类的父类,即目标类(目标类和代理类是继承关系),等同于上面一句代码
				//后方发
				//as.after();
				return retval;
			}
		});
		//创建代理
		
		return (IUserService)eh.create();
	}
}
