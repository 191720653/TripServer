package com.zehao.model;

import java.util.Date;

/**
 * ViewImage entity. @author MyEclipse Persistence Tools
 */

public class ViewImage implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8766704723460209469L;
	private Integer imageId;
	private Views views;
	private Users users;
	private String imageInfo;
	private String imageUrl;
	private Date createDate;
	private String remark;

	// Constructors

	/** default constructor */
	public ViewImage() {
	}

	/** full constructor */
	public ViewImage(Views views, Users users, String imageInfo,
			String imageUrl, Date createDate, String remark) {
		this.views = views;
		this.users = users;
		this.imageInfo = imageInfo;
		this.imageUrl = imageUrl;
		this.createDate = createDate;
		this.remark = remark;
	}

	// Property accessors

	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Views getViews() {
		return this.views;
	}

	public void setViews(Views views) {
		this.views = views;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getImageInfo() {
		return this.imageInfo;
	}

	public void setImageInfo(String imageInfo) {
		this.imageInfo = imageInfo;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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