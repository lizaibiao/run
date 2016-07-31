
/**   
 * Copyright © 2016 公司名. All rights reserved.
 * 
 * @Title: Test.java 
 * @Prject: run
 * @Package: com.run.util.test 
 * @Description: TODO
 * @author: lizaibiao
 * @date: 2016年7月31日 上午11:52:47 
 * @version: V1.0   
 */

package com.run.util.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.run.enmu.EnStatus;
import com.run.entity.UserEn;
import com.run.service.UserService;
import com.run.util.UUIDUtil;

/** 
 * @ClassName: Test 
 * @Description: TODO
 * @author: lizaibiao
 * @date: 2016年7月31日 上午11:52:47  
 */
public class Test extends AbstractTest  {
	@Autowired
	private UserService userService;
	/*
	 * RUN
	 */
   @org.junit.Test
    public void testExecute() {
	    UserEn user=new UserEn();
	    user.setId(UUIDUtil.getUUID());
		user.setCode("123");
		user.setCreateTime(new Date());
		user.setEmStatus(EnStatus.valueOf(0));
		user.setMobile("13162371305");
		user.setName("哈哈4");
	   userService.saveUser(user);
    }
	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

