package cn.supreme.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.supreme.mybatis.mapper.OrdersMapper;
import cn.supreme.mybatis.mapper.UserMapper;
import cn.supreme.mybatis.po.OrdersExt;
import cn.supreme.mybatis.po.User;
import cn.supreme.mybatis.po.UserVO;

public class MybatisMapperTest {

	SqlSessionFactory sqlSessionFactory = null;// 单例

	@Before
	public void setUp() throws IOException {
		// 读取配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建sqlsessionfactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void findUserById() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.findUserById(28);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void findUserByName() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = userMapper.findUserByName("董浩");
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
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			User user = new User();
			user.setUsername("董浩浩");
			user.setSex("1");
			user.setAddress("浙江省杭州市余杭区");

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
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

	@Test
	public void findUserByIdList() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			// 1. 通过包装类实现
			// UserVO userVO = new UserVO();
			// List<Integer> idList = new ArrayList<>();
			// idList.add(1);
			// idList.add(25);
			// idList.add(27);
			// idList.add(30);
			// userVO.setIdList(idList);
			//
			// UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// List<User> userList = userMapper.findUserByIdList(userVO);

			// 2. 直接通过list类型实现
			List<Integer> idList = new ArrayList<>();
			idList.add(1);
			idList.add(25);
			idList.add(26);
			idList.add(27);
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<User> userList = userMapper.findUserByIdList(idList);

			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void findOrdersAndUsers() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
			List<OrdersExt> ordersExts = ordersMapper.findOrdersAndUsers();
			System.out.println(ordersExts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void findOrdersAndUsersRstMap() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
			List<OrdersExt> ordersExts = ordersMapper.findOrdersAndUsersRstMap();
			System.out.println(ordersExts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}

	@Test
	public void findOrdersAndOrderDetailRstMap() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
			List<OrdersExt> ordersExts = ordersMapper.findOrdersAndOrderDetailRstMap();
			System.out.println(ordersExts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}
	
	@Test
	public void findUsersAndOrderDetailRstMap() {
		SqlSession sqlSession = null;
		try {
			// 创建sqlsession
			sqlSession = sqlSessionFactory.openSession();

			// 执行executor、mappedstatement,返回执行结果
			OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
			List<User> users = ordersMapper.findUsersAndOrderDetailRstMap();
			System.out.println(users);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			sqlSession.close();
		}
	}
}
