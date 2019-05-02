package cn.supreme.mybatis.mapper;

import java.util.List;

import cn.supreme.mybatis.po.User;
import cn.supreme.mybatis.po.UserVO;

public interface UserMapper {

	User findUserById(int id);

	List<User> findUserByName(String username);

	void insertUser(User user);

	List<User> findUserByIdList(List<Integer> idList);

	List<User> findUserByUserVo(UserVO userVO);

}
