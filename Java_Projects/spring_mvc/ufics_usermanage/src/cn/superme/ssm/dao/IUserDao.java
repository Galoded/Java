package cn.superme.ssm.dao;

import java.util.List;

import cn.superme.ssm.pojo.Users;

public interface IUserDao {
	
	List<Users> findAllUsers();

	Users findUsersById(String user_id);

	void updateUsersById(Users user);
	
	void insertUsers(Users user);
	
	void deleteUsersById(String user_id);

	List<Users> findUsersByIdorName(String user_id_name);

	void deleteUsersByIds(String[] user_ids);
	
}
