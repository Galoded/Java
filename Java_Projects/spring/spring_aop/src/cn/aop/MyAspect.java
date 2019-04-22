package cn.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("---执行前方法---");

		//目标方法执行
		Object obj = mi.proceed();
		
		System.out.println("---执行后方法---");
		
		return obj;
	}
}
