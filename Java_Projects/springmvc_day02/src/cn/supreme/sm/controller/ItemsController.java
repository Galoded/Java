package cn.supreme.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.supreme.sm.po.Items;
import cn.supreme.sm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Resource
	private ItemsService itemsService;

	@RequestMapping("list")
	public String findAll(Model model) {
		List<Items> itemsList = itemsService.findAll();
		model.addAttribute("itemsList", itemsList);
		return "itemsList";
	}

	// 根据名称查找
	@RequestMapping("itemsByName")
	public String findItemsByName(String name, Model model) {
		if (name != null && name.trim().length() != 0) {
			List<Items> itemsList = itemsService.findItemsByName(name);
			model.addAttribute("itemsList", itemsList);
		} else {
			this.findAll(model);
		}
		return "itemsList";
	}

	// 新增item
	@RequestMapping("toAddItem")
	public String toAddItem() {
		// 跳转到addItems.jsp页面
		return "addItems";
	}

	@RequestMapping("addItem")
	public String addItem(Items item, Model model) {
		itemsService.insert(item);
		return this.findAll(model);
		// return "itemsList";
	}

	// 修改item
	@RequestMapping("toEditItems")
	public String toEditItem(Integer id, Model model) {
		Items item = itemsService.findItemByID(id);
		model.addAttribute("item", item);
		return "editItem";
	}

	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items item, Model model) {
		itemsService.saveOrUpdate(item);
		return this.findAll(model);
	}
	
	//删除item
	@RequestMapping("deleteByID")
	public String deleteByID(Integer id, Model model) {
		itemsService.deleteByID(id);
		return this.findAll(model);
	}

}
