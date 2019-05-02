package cn.superme.mybatis.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.superme.mybatis.mapper.UserMapper;
import cn.superme.mybatis.po.User;

public class TestMybatiSpring {

	@SuppressWarnings("resource")
	@Test
	public void testMybatispring() {

		String str = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(str);
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
}
