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
	
	public List<Items> findAll() {
		List<Items> items = itemsMapper.findAll();
		return items;
	}
}
