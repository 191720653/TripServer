package com.zehao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Views entity. @author MyEclipse Persistence Tools
 */

public class Views implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 967391582159680006L;
	private Integer viewId;
	private Village village;
	private String viewName;
	private String viewAddress;
	private String viewGuide;
	private String viewInfo;
	private String viewLogo;
	private String openTime;
	private String ticket;
	private String phone;
	private Date createDate;
	private String remark;
	private Set<ViewImage> viewImages = new HashSet<ViewImage>(0);
	private Set<ViewVoice> viewVoices = new HashSet<ViewVoice>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Views() {
	}

	/** full constructor */
	public Views(Village village, String viewName, String viewAddress,
			String viewGuide, String viewInfo, String viewLogo,
			String openTime, String ticket, String phone, Date createDate,
			String remark, Set<ViewImage> viewImages, Set<ViewVoice> viewVoices, Set<Comment> comments) {
		this.village = village;
		this.viewName = viewName;
		this.viewAddress = viewAddress;
		this.viewGuide = viewGuide;
		this.viewInfo = viewInfo;
		this.viewLogo = viewLogo;
		this.openTime = openTime;
		this.ticket = ticket;
		this.phone = phone;
		this.createDate = createDate;
		this.remark = remark;
		this.viewImages = viewImages;
		this.viewVoices = viewVoices;
		this.comments = comments;
	}

	// Property accessors

	public Integer getViewId() {
		return this.viewId;
	}

	public void setViewId(Integer viewId) {
		this.viewId = viewId;
	}

	public Village getVillage() {
		return this.village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getViewName() {
		return this.viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewAddress() {
		return this.viewAddress;
	}

	public void setViewAddress(String viewAddress) {
		this.viewAddress = viewAddress;
	}

	public String getViewGuide() {
		return this.viewGuide;
	}

	public void setViewGuide(String viewGuide) {
		this.viewGuide = viewGuide;
	}

	public String getViewInfo() {
		return this.viewInfo;
	}

	public void setViewInfo(String viewInfo) {
		this.viewInfo = viewInfo;
	}

	public String getViewLogo() {
		return this.viewLogo;
	}

	public void setViewLogo(String viewLogo) {
		this.viewLogo = viewLogo;
	}

	public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set<ViewImage> getViewImages() {
		return this.viewImages;
	}

	public void setViewImages(Set<ViewImage> viewImages) {
		this.viewImages = viewImages;
	}

	public Set<ViewVoice> getViewVoices() {
		return this.viewVoices;
	}

	public void setViewVoices(Set<ViewVoice> viewVoices) {
		this.viewVoices = viewVoices;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}