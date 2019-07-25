package cn.superme.ssm.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.superme.ssm.dao.IUserDao;
import cn.superme.ssm.mapper.UsersMapper;
import cn.superme.ssm.pojo.Users;

@Repository
public class UserDao implements IUserDao{

	@Autowired
	private UsersMapper userMapper;
	
	@Override
	public List<Users> findAllUsers() {
		List<Users> usersList = userMapper.findAllUsers();
		return usersList;
	}

	@Override
	public Users findUsersById(String user_id) {
		Users users = userMapper.findUsersById(user_id);
		return users;
	}

	@Override
	public void updateUsersById(Users user) {
		userMapper.updateUsersById(user);
	}

	@Override
	public void insertUsers(Users user) {
		userMapper.insertUsers(user);		
	}

	@Override
	public void deleteUsersById(String user_id) {
		userMapper.deleteUsersById(user_id);		
	}

	@Override
	public List<Users> findUsersByIdorName(String user_id_name) {
		List<Users> userList = userMapper.findUsersByIdorName(user_id_name);
		return userList;
	}

	@Override
	public void deleteUsersByIds(String[] user_ids) {
		userMapper.deleteUsersByIds(user_ids);	
	}

}
