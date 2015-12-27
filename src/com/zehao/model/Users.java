package com.zehao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6078978739544674028L;
	private Integer userId;
	private String account;
	private String password;
	private String nickName;
	private String trueName;
	private Integer sex;
	private Date birthday;
	private String icon;
	private String phone;
	private String email;
	private String qq;
	private String wechat;
	private String info;
	private Integer sign;
	private Date createDate;
	private Date lastUpdate;
	private String remark;
	private Set<ViewVoice> viewVoices = new HashSet<ViewVoice>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<ViewImage> viewImages = new HashSet<ViewImage>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String account, String password, String nickName,
			String trueName, Integer sex, Date birthday, String icon,
			String phone, String email, String qq, String wechat, String info,
			Integer sign, Date createDate, Date lastUpdate, String remark,
			Set<ViewVoice> viewVoices, Set<Comment> comments, Set<ViewImage> viewImages) {
		this.account = account;
		this.password = password;
		this.nickName = nickName;
		this.trueName = trueName;
		this.sex = sex;
		this.birthday = birthday;
		this.icon = icon;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.wechat = wechat;
		this.info = info;
		this.sign = sign;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.remark = remark;
		this.viewVoices = viewVoices;
		this.comments = comments;
		this.viewImages = viewImages;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return this.wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Set<ViewImage> getViewImages() {
		return this.viewImages;
	}

	public void setViewImages(Set<ViewImage> viewImages) {
		this.viewImages = viewImages;
	}

}