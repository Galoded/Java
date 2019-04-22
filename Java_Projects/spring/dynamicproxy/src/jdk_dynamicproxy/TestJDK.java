package jdk_dynamicproxy;

import org.junit.Test;

public class TestJDK {

	@Test
	public void testJdk() {

		IUserService proxy = (IUserService) MyProxyFactory.createProxyInstance();
		proxy.addUser();

	}
}
