package cglib_dynamicproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyProxyFactory {

	public static Object createProxyInstance() {
		// 目标对象
		final UserService user = new UserService();

		final MyAspect myaspect = new MyAspect();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);
		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {

				myaspect.before();

				// 执行目标类方法
				Object obj = method.invoke(user, args);

				myaspect.after();

				return obj;
			}
		});

		// 创建代理对象
		Object proxyObject = enhancer.create();
		return proxyObject;
	}
}
