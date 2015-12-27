package com.zehao.model;

import java.util.Date;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 4869470227012215390L;
	private Integer commentId;
	private Views views;
	private Users users;
	private String content;
	private Date createDate;
	private String score;
	private String remark;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Views views, Users users, String content, Date createDate,
			String score, String remark) {
		this.views = views;
		this.users = users;
		this.content = content;
		this.createDate = createDate;
		this.score = score;
		this.remark = remark;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}