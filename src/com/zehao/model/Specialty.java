package com.zehao.model;

import java.util.Date;

/**
 * Specialty entity. @author MyEclipse Persistence Tools
 */

public class Specialty implements java.io.Serializable {

	private static final long serialVersionUID = 8658416866442401167L;
	// Fields

	private Integer specialId;
	private String specialName;
	private String specialInfo;
	private String specialAddress;
	private Date createDate;
	private String remark;

	// Constructors

	/** default constructor */
	public Specialty() {
	}

	/** full constructor */
	public Specialty(String specialName, String specialInfo,
			String specialAddress, Date createDate, String remark) {
		this.specialName = specialName;
		this.specialInfo = specialInfo;
		this.specialAddress = specialAddress;
		this.createDate = createDate;
		this.remark = remark;
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

}