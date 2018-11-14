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
		List<Items> items = itemsService.findAll();
		model.addAttribute("itemsList", items);
		return "itemsList";
	}
}
