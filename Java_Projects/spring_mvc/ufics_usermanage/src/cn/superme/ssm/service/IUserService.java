package cn.superme.ssm.service;

import java.util.List;

import cn.superme.ssm.pojo.Users;

public interface IUserService {

	List<Users> findAllUsers();

	void updateUsersById(Users user);

	Users findUsersById(String user_id);

	void insertUsers(Users user);

	void deleteUsersById(String user_id);

	List<Users> findUsersByIdorName(String user_id_name);

	void deleteUsersByIds(String[] user_ids);
}
