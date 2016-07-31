package com.run.web.admin;



import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.run.enmu.EnStatus;
import com.run.entity.UserEn;
import com.run.service.UserService;
import com.run.util.UUIDUtil;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

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
		user.setId(UUIDUtil.getUUID());
		user.setCode("123");
		user.setCreateTime(new Date());
		user.setEmStatus(EnStatus.valueOf(0));
		user.setMobile("13162371305");
		user.setName("哈哈4");
		userService.saveUser(user);
		return "redirect:/admin/article/toAtricleList";
	}
}
