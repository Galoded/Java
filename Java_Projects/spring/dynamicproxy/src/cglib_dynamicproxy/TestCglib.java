package cglib_dynamicproxy;

import org.junit.Test;

public class TestCglib {

	@Test
	public void testCglib() {
		
		// 获取代理对象实例
		UserService proxy = (UserService) MyProxyFactory.createProxyInstance();
		proxy.addUser();
	}
}
