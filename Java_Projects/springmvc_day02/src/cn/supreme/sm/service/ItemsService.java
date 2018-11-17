package cn.supreme.sm.service;

import java.util.List;

import cn.supreme.sm.po.Items;

public interface ItemsService {

	List<Items> findAll();

	List<Items> findItemsByName(String name);

	void insert(Items item);

	void saveOrUpdate(Items item);

	Items findItemByID(Integer id);

	void deleteByID(Integer id);

}
