package cn.supreme.mybatis.mapper;

import java.util.List;

import cn.supreme.mybatis.po.User;
import cn.supreme.mybatis.po.UserVO;

public interface UserMapper {
	
	public User findUserById(int id);

	public List<User> findUserByName(String username);

	public void insertUser(User user);
	
	//public List<User> findUserByIdList(UserVO userVO);
	public List<User> findUserByIdList(List<Integer> idList);
}
