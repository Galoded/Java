package cn.aspect;

public class UserServiceImpl implements IUserService {

	@Override
	public void addUser() {
		System.out.println("新增用户");
	}

	@Override
	public void updateUser() {
		System.out.println("更新用户");

	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");

	}

}
