package cn.supreme.mybatis.demo;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.supreme.mybatis.po.User;

public class MybatisFirst {

	@Test
	public void findUserById() {
		// 读取配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);

			// 创建sqlsessionfactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor
			User user = sqlSession.selectOne("test.findUserById", 1);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void findUserByName() {
		// 读取配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);

			// 创建sqlsessionfactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			List<User> userList = sqlSession.selectList("test.findUserByName", "小明");
			System.out.println(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void insertUser() {
		// 读取配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);

			// 创建sqlsessionfactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			User user = new User();
			user.setUsername("董浩");
			user.setSex("1");
			user.setAddress("杭州");

			sqlSession.insert("test.insertUser", user);
			
			//System.out.println(user.getId());

			// 事务提交
			sqlSession.commit();
			
			System.out.println(user.getId());
		} catch (Exception e) {
			// 报错则事务回滚
			sqlSession.rollback();
			
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}
}
