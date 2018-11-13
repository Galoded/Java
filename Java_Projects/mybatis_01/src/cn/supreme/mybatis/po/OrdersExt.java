package cn.supreme.mybatis.po;

import java.util.List;

public class OrdersExt extends Orders {

	private String username;
	private String sex;
	private User user;
	private List<Orderdetail> orderdetails;

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "OrdersExt [username=" + username + ", sex=" + sex + ", user=" + user + ", orderdetails=" + orderdetails
				+ "]";
	}

	

}
