package cn.supreme.mybatis.po;

import java.util.List;

public class UserVO {
	
	private List<Integer> idList;

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
