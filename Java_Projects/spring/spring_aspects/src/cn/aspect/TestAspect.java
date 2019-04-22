package cn.aspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

	@SuppressWarnings("resource")
	@Test
	public void testAspect() {
		String str = "classpath:applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(str);
		IUserService user = (IUserService) applicationContext.getBean("userServiceImpl");
		user.addUser();
	}
}
