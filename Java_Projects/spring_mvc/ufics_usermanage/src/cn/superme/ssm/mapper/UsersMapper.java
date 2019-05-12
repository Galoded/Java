package cn.superme.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.superme.ssm.pojo.Users;

public interface UsersMapper {

	List<Users> findAllUsers();

	Users findUsersById(String user_id);

	void updateUsersById(@Param("record") Users user);
	
	void insertUsers(@Param("record") Users user);
	
	void deleteUsersById(String user_id);
}
