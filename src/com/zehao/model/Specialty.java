package com.zehao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Specialty entity. @author MyEclipse Persistence Tools
 */

public class Specialty implements java.io.Serializable {

	// Fields

	private Integer specialId;
	private String specialName;
	private String specialInfo;
	private String specialAddress;
	private Date createDate;
	private String remark;
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Specialty() {
	}

	/** full constructor */
	public Specialty(String specialName, String specialInfo,
			String specialAddress, Date createDate, String remark, Set comments) {
		this.specialName = specialName;
		this.specialInfo = specialInfo;
		this.specialAddress = specialAddress;
		this.createDate = createDate;
		this.remark = remark;
		this.comments = comments;
	}

	// Property accessors

	public Integer getSpecialId() {
		return this.specialId;
	}

	public void setSpecialId(Integer specialId) {
		this.specialId = specialId;
	}

	public String getSpecialName() {
		return this.specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	public String getSpecialInfo() {
		return this.specialInfo;
	}

	public void setSpecialInfo(String specialInfo) {
		this.specialInfo = specialInfo;
	}

	public String getSpecialAddress() {
		return this.specialAddress;
	}

	public void setSpecialAddress(String specialAddress) {
		this.specialAddress = specialAddress;
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