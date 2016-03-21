package com.zehao.model;

import java.util.Date;

/**
 * Suggest entity. @author MyEclipse Persistence Tools
 */

public class Suggest implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -2018359279747247991L;
	private Integer suggestId;
	private Integer userId;
	private String suggestContent;
	private Date createDate;

	// Constructors

	/** default constructor */
	public Suggest() {
	}

	/** full constructor */
	public Suggest(Integer userId, String suggestContent, Date createDate) {
		this.userId = userId;
		this.suggestContent = suggestContent;
		this.createDate = createDate;
	}

	// Property accessors

	public Integer getSuggestId() {
		return this.suggestId;
	}

	public void setSuggestId(Integer suggestId) {
		this.suggestId = suggestId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSuggestContent() {
		return this.suggestContent;
	}

	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}