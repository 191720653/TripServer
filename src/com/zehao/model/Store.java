package com.zehao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Integer storeId;
	private String storeName;
	private String storeInfo;
	private String storeAddress;
	private String storeTime;
	private Date createDate;
	private String remark;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** full constructor */
	public Store(String storeName, String storeInfo, String storeAddress,
			String storeTime, Date createDate, String remark, Set comments) {
		this.storeName = storeName;
		this.storeInfo = storeInfo;
		this.storeAddress = storeAddress;
		this.storeTime = storeTime;
		this.createDate = createDate;
		this.remark = remark;
		this.comments = comments;
	}

	// Property accessors

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreInfo() {
		return this.storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreTime() {
		return this.storeTime;
	}

	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}