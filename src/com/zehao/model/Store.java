package com.zehao.model;

import java.util.Date;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1663594371422174783L;
	private Integer storeId;
	private String storeName;
	private String storeInfo;
	private String storeAddress;
	private String storeTime;
	private Date createDate;
	private String remark;

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** full constructor */
	public Store(String storeName, String storeInfo, String storeAddress,
			String storeTime, Date createDate, String remark) {
		this.storeName = storeName;
		this.storeInfo = storeInfo;
		this.storeAddress = storeAddress;
		this.storeTime = storeTime;
		this.createDate = createDate;
		this.remark = remark;
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

}