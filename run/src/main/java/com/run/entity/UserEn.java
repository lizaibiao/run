package com.run.entity;

import java.util.Date;

import com.run.enmu.EnStatus;

/**
 * 
 * @ClassName: UserEn 
 * @Description: 用户类
 * @author: lizaibiao
 * @date: 2016年7月2日 下午8:27:53
 */
public class UserEn {
	/*
	 * 主键
	 */
	private String id;
	/*
	 * 用户编码
	 */
	private String code;
	
	/*
	 * 姓名
	 */
	private String name;
	
	/*
	 * 手机号
	 */
	private String mobile;
	/*
	 * 创建时间
	 */
	private Date createTime;
	
	/*
	 * 修改时间
	 */
	private Date lastModifyTime;
	/*
	 * 状态
	 */
	private EnStatus emStatus;
	

	/**
	 * @return the status
	 */
	public int getStatus() {
        return emStatus == null ? 0 : emStatus.getValue();
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		setEmStatus(EnStatus.valueOf(status));
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the lastModifyTime
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	/**
	 * @param lastModifyTime the lastModifyTime to set
	 */
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	/**
	 * @return the emStatus
	 */
	public EnStatus getEmStatus() {
		return emStatus;
	}

	/**
	 * @param emStatus the emStatus to set
	 */
	public void setEmStatus(EnStatus emStatus) {
		this.emStatus = emStatus;
	}


}
