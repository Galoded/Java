package cn.superme.ssm.controller;

import cn.superme.ssm.pojo.Users;
import cn.superme.ssm.service.IUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "list")
	public String findAllUsers(Model model) {
		List<Users> usersList = userService.findAllUsers();
		model.addAttribute("usersList", usersList);
		return "users";
	}

	@RequestMapping(value = "findUser")
	private Users findUsersByIdorName(String user_id_name, Model model) {
		List<Users> usersList = userService.findUsersByIdorName(user_id_name);
		model.addAttribute("usersList", usersList);
		return usersList;
	}

	@RequestMapping(value = "usersUpdateById/{user_id}")
	public String updateUsers(@PathVariable String user_id, Model model) {
		Users users = this.findUsersById(user_id);
		model.addAttribute("users", users);
		return "usersUpdate";
	}

	@RequestMapping(value = "usersUpdate")
	public String updateUsersById(Users user) {
		if (user != null && user.getUser_id() != null && user.getUser_id().length() > 0) {
			userService.updateUsersById(user);
		}
		return "redirect:list.do";
	}

	@RequestMapping(value = "usersInsert")
	public String insertUsers(Users user) {
		if (user != null) {
			userService.insertUsers(user);
		}
		return "redirect:list.do";
	}

	@RequestMapping(value = "usersDeleteById")
	public String deleteUsersById(String user_id) {
		userService.deleteUsersById(user_id);
		return "redirect:list.do";
	}

	private Users findUsersById(String user_id) {
		Users users = userService.findUsersById(user_id);
		return users;
	}

}
