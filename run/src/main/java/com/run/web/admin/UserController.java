package com.run.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.run.entity.UserEn;
import com.run.service.UserService;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController<T> {

	@SuppressWarnings("rawtypes")
	@Resource
	public UserService userService;
	
	
	/**
	 * 
	 * @Title: saveUser 
	 * @Description: 保存用户实体
	 * @param user
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/saveUser")
	private String saveUser(UserEn user){
		userService.saveUser(user);
		return "redirect:/admin/article/toAtricleList";
	}
}
