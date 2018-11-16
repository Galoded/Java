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
	@RequestMapping("toAddItems")
	public String toAddItems() {
		// 跳转到addItems.jsp页面
		return "addItems";
	}

	@RequestMapping("addItems")
	public String addItems(Items item,Model model) {
		itemsService.insert(item);
		return this.findAll(model);
		//return "itemsList";
	}
}
