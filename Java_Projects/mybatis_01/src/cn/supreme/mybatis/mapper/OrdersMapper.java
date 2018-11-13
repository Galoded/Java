package cn.supreme.mybatis.mapper;

import java.util.List;

import cn.supreme.mybatis.po.OrdersExt;
import cn.supreme.mybatis.po.User;

public interface OrdersMapper {
	public List<OrdersExt> findOrdersAndUsers();

	public List<OrdersExt> findOrdersAndUsersRstMap();

	public List<OrdersExt> findOrdersAndOrderDetailRstMap();

	// 多对多映射
	public List<User> findUsersAndOrderDetailRstMap();
}
