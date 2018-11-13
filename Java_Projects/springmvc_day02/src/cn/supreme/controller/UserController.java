package cn.supreme.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.supreme.model.User;
import cn.supreme.model.UserCustom;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("index")
	public String receiveIndex() {

		//return "index";
		//转发
		//return "forward:/user/userList.do";
		//重定向
		//return "redirect:/user/userList.do";
		return "requestJson";
	}

	@RequestMapping("receiveInt")
	public String receiveInt(@RequestParam(defaultValue="2",value="userId",required=true)Integer userId) {
		System.out.println(userId);
		return "success";
	}

	@RequestMapping("receiveUser")
	public String receiveUser(User user) {
		System.out.println(user);
		return "success";
	}
	
	@RequestMapping("receiveUserJson")
	public @ResponseBody User receiveUserJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
	@RequestMapping("requestPojo")
	public @ResponseBody User requestPojo(User user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("receiveUserCustom")
	public String receiveUserCustom(UserCustom userCustom) {
		System.out.println(userCustom.getUser().getName() + "\n" + userCustom.getUser().getAge() + "\n"
				+ userCustom.getUser().getBirthday());
		return "success";
	}

	@RequestMapping("userList")
	public String receiveUserList(Model model) {

		List<User> userList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			User temp = new User();
			temp.setName("董浩" + i);
			temp.setAge(i);
			temp.setBirthday(new Date());
			userList.add(temp);

		}

		model.addAttribute("userList", userList);

		return "list";

	}

	/*
	 * restfull设计模式：无扩展名的url映射，需要servlet配置可目录匹配的url-mapping
	 * 参数名称相同
	 * @PathVariable标注
	 */
	@RequestMapping("update/{name}")
	public String update(Integer id, @PathVariable String name,Model model) {

		model.addAttribute("fullName", name);

		return "nameJsp";
	}

}
