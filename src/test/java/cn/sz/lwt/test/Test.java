package cn.sz.lwt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sz.lwt.service.IUserService;
import cn.sz.lwt.service.impl.CglibFactory;
import cn.sz.lwt.service.impl.ProxyFactory;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//IUserService proxyService =  (IUserService) ac.getBean("proxyServiceId");//半自动
		IUserService proxyService =  (IUserService) ac.getBean("userServiceId");//全自动
		proxyService.addUser();
		proxyService.deleteUser();
		proxyService.updateUser();
	}

}
