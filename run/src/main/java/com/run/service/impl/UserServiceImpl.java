package com.run.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.run.common.dao.IGenericExtDao;
import com.run.entity.UserEn;
import com.run.service.UserService;

/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: 用户实现类
 * @author: lizaibiao
 * @date: 2016年7月2日 下午10:38:00 
 * @param <T>
 */
@Service
public class UserServiceImpl<T> implements UserService<T> {

	@SuppressWarnings("rawtypes")
	@Resource
	private IGenericExtDao<T> genericExtDao;


	/* (non Javadoc) 
	 * @Title: saveUser
	 * @Description: 保存用户实体
	 * @param userEn 
	 * @see com.run.service.UserService#saveUser(com.run.entity.UserEn) 
	 */
	@Override
	public void saveUser(UserEn userEn) {
		
	}

	
}
