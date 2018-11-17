package cn.supreme.sm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.supreme.sm.mapper.ItemsMapper;
import cn.supreme.sm.po.Items;
import cn.supreme.sm.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Resource
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> findAll() {
		List<Items> items = itemsMapper.findAll();
		return items;
	}

	@Override
	public List<Items> findItemsByName(String name) {
		List<Items> items = itemsMapper.findItemsByName(name);
		return items;
	}

	@Override
	public void insert(Items item) {
		itemsMapper.insert(item);

	}

	@Override
	public void saveOrUpdate(Items item) {
		itemsMapper.updateByPrimaryKey(item);
	}

	@Override
	public Items findItemByID(Integer id) {
		Items item = itemsMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public void deleteByID(Integer id) {
		itemsMapper.deleteByPrimaryKey(id);
	}
}
