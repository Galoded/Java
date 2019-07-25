package cn.superme.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.superme.ssm.dao.IUserDao;
import cn.superme.ssm.pojo.Users;
import cn.superme.ssm.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public List<Users> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public Users findUsersById(String user_id) {
		return userDao.findUsersById(user_id);
	}
	
	@Override
	public void updateUsersById(Users user) {
		userDao.updateUsersById(user);
	}

	@Override
	public void insertUsers(Users user) {
		userDao.insertUsers(user);		
	}

	@Override
	public void deleteUsersById(String user_id) {
		userDao.deleteUsersById(user_id);		
	}

	@Override
	public List<Users> findUsersByIdorName(String user_id_name) {
		List<Users> userList = userDao.findUsersByIdorName(user_id_name);	
		return userList;
	}

	@Override
	public void deleteUsersByIds(String[] user_ids) {
		userDao.deleteUsersByIds(user_ids);		
		
	}

}
