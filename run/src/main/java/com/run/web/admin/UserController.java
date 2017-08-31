package com.run.web.admin;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.run.common.entity.Page;
import com.run.dto.UserEnDto;
import com.run.entity.UserEn;
import com.run.service.UserService;


@Controller
@RequestMapping(value = "/admin/user")
public class UserController {

	@Resource
	public UserService userService;
	
	/**
	 * 保存用户实体
	 */
	@RequestMapping(value = "/saveUser")
	@ResponseBody
	private JSONObject saveUser(Model model,UserEn user){
		JSONObject json = new JSONObject();
		userService.saveUser(user);
		return json;
	}
	/**
	 * 查询一个实体
	 */
	
	@RequestMapping(value = "/getOneUser")
	@ResponseBody
	private JSONObject getOneUser(Model model,UserEn user){
		JSONObject json = new JSONObject();
		UserEn en	=userService.getOneUser(user);
		json.put("en",en);
		return json;
	}
	
	/**
	 * 删除用户实体
	 */
	@RequestMapping(value = "/delUser")
	@ResponseBody
	private JSONObject delUser(Model model,UserEnDto user,String ids){
		JSONObject json = new JSONObject();
		userService.delUser(user,ids);
		return json;

	}
	
	
	/**
	 * 查询用户实体（分页）
	 */
	@RequestMapping(value = "/getUserPage")
	@ResponseBody
	private JSONObject getUserPage(Model model,UserEnDto user,Page page2 ,int page, int rows, String order, String sort,String name2){
		page2.setCurrentPage(page);
		page2.setShowCount(rows);
		JSONObject json = new JSONObject();
		Page userPage=userService.getUserPage(user, page2,order,sort);
		model.addAttribute("page", userPage);
		json.put("rows",userPage.getDataList());
		json.put("total",userPage.getTotalResult());
		return json;
		}
	
}
