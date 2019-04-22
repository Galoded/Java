package cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void roundFunc(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("---前方法执行---");
		
		//目标方法执行
		joinPoint.proceed();
		
		System.out.println("---后方法执行---");
	}
}
