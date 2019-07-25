package cn.superme.ssm.controller;

import cn.superme.ssm.pojo.Users;
import cn.superme.ssm.service.IUserService;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "user")
	public String openUserPage(Model model) {
		// List<Users> usersList = userService.findAllUsers();
		// model.addAttribute("usersList", usersList);
		return "users";
	}

	/*
	 * 页面定位
	 */
	@RequestMapping(value = "user2")
	public String openUser2Page(Model model) {
		return "users2";
	}

	/*
	 * 加载所有用户信息
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public String findAllUsers() {
		List<Users> usersList = userService.findAllUsers();
		String jsonstr = JSON.toJSONStringWithDateFormat(usersList, "yyyy-MM-dd");
		return jsonstr;
	}

	/*
	 * 根据用户id或者user_name模糊查找用户
	 */
	@RequestMapping(value = "searchUsers")
	@ResponseBody
	private String findUsersByIdorName(@RequestParam("value") String user_id_name) {
		String jsonstr = null;
		if (user_id_name == null || user_id_name.length() == 0) {
			jsonstr = findAllUsers();
		} else {
			List<Users> usersList = userService.findUsersByIdorName(user_id_name);
			jsonstr = JSON.toJSONStringWithDateFormat(usersList, "yyyy-MM-dd");
		}
		return jsonstr;
	}

	/*
	 * 根据用户id精确查询用户
	 */
	@RequestMapping(value = "findUsersById")
	@ResponseBody
	public String findUsersById(@RequestParam("value") String user_id) {
		try {
			String jsonstr = null;
			if(user_id == null || user_id.length() == 0){
				return null;
			}
			Users user = userService.findUsersById(user_id);
			jsonstr = JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd");
			return jsonstr;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/*
	 * 更新用户信息
	 */
	@RequestMapping(value = "usersUpdate")
	@ResponseBody
	public String updateUsersById(Users user) {
		try {
			if (user != null && user.getUser_id() != null && user.getUser_id().length() > 0) {
				userService.updateUsersById(user);
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/*
	 * 新增用户信息
	 */
	@RequestMapping(value = "usersInsert")
	@ResponseBody
	public String insertUsers(Users user) {
		try {
			if (user != null) {
				userService.insertUsers(user);
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/*
	 * 根据用户id删除用户信息
	 */
	@RequestMapping(value = "usersDeleteById")
	@ResponseBody
	public String deleteUsersById(String user_id) {
		try {
			userService.deleteUsersById(user_id);
			return "success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/*
	 * 批量删除用户信息
	 */
	@RequestMapping(value = "usersDeleteByIds", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUsersByIds(String user_ids) {
		String[] ids = user_ids.split(",");
		userService.deleteUsersByIds(ids);
		return "success";
	}

}
