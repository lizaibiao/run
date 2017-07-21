package com.run.service;

import com.run.common.entity.Page;
import com.run.dto.UserEnDto;
import com.run.entity.UserEn;
/**
 * 
 * @ClassName: UserService 
 * @Description: 用户类接口
 * @author: lizaibiao
 * @date: 2016年7月2日 下午10:37:01 
 * @param <T>
 */
public interface UserService {
	/*
	 * 保存用户
	 */
   public void saveUser(UserEn userEn);
	 /*
	  * 分页
	  */
    Page getUserPage(UserEnDto userEn,Page page,String sortName,String sort);
}
