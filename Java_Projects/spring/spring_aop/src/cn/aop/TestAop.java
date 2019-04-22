package cn.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

	@SuppressWarnings("resource")
	@Test
	public void testAop() {
		String str = "classpath:applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(str);
		IUserService user = (IUserService) applicationContext.getBean("userServiceImpl");
		user.addUser();
	}
}
