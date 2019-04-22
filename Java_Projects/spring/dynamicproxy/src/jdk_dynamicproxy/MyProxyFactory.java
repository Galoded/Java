package jdk_dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyFactory {

	public static Object createProxyInstance() {
		
		//目标类对象
		final IUserService user = new UserServiceImpl();
		
		final MyAspect myAspect = new MyAspect();
		
		//创建代理对象proxy
		IUserService proxyObject = (IUserService) Proxy.newProxyInstance(
				IUserService.class.getClassLoader(),
				new Class[] { IUserService.class }, 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//方法前执行
						myAspect.before();
						
						//目标类方法执行
						Object obj = method.invoke(user, args);
						
						//方法后执行
						myAspect.after();
						
						return obj;
					}
					
				});
		return proxyObject;
	}
}
