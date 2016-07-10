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
import com.run.entity.UserEn;
import com.run.service.UserService;
import com.square.common.dao.IGenericExtDao;
import com.square.common.domain.Page;
import com.square.domain.ArticleEntity;
import com.square.domain.ReplyEntity;
import com.square.domain.UserEntity;
import com.square.service.IArticleService;
import com.square.service.IReplyService;
import com.square.util.DateUtil;
import com.square.util.FileUtil;
import com.square.util.SessionFactory;
import com.square.util.StrUtil;
import com.square.util.UUIDUtil;
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
	private IGenericExtDao genericExtDao;

	@SuppressWarnings("rawtypes")
	@Resource
	public IReplyService replyService;

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
