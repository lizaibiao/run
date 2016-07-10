package com.run.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
