package com.zehao.model;

import java.util.Date;

/**
 * ViewVoice entity. @author MyEclipse Persistence Tools
 */

public class ViewVoice implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 4956800251841667213L;
	private Integer voiceId;
	private Views views;
	private Users users;
	private String voiceInfo;
	private String voiceUrl;
	private Date createDate;
	private String remark;

	// Constructors

	/** default constructor */
	public ViewVoice() {
	}

	/** full constructor */
	public ViewVoice(Views views, Users users, String voiceInfo,
			String voiceUrl, Date createDate, String remark) {
		this.views = views;
		this.users = users;
		this.voiceInfo = voiceInfo;
		this.voiceUrl = voiceUrl;
		this.createDate = createDate;
		this.remark = remark;
	}

	// Property accessors

	public Integer getVoiceId() {
		return this.voiceId;
	}

	public void setVoiceId(Integer voiceId) {
		this.voiceId = voiceId;
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

	public String getVoiceInfo() {
		return this.voiceInfo;
	}

	public void setVoiceInfo(String voiceInfo) {
		this.voiceInfo = voiceInfo;
	}

	public String getVoiceUrl() {
		return this.voiceUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
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