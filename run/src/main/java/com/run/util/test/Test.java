
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
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
@SuppressWarnings("unused")
public class Test extends AbstractTest  {
	@Autowired
	private UserService userService;
	/*
	 * RUN
	 */
   @org.junit.Test
    public void testExecute() {
	   UserEn userEn=new UserEn();
	   userEn.setId("666");
	   userEn.setName("666");
	   userEn.setCode("666");
	   userEn.setCreateTime(new Date());
	   userService.saveUser(userEn);
	   //userService.getUserPage(null, null,null,null);
    }
	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("id", 1);
		System.out.print(json);

	}
}

