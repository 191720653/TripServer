package com.zehao.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String sina;
	private String info;
	private Integer sign;
	private String token;
	private String type;
	private String typeId;
	private String loginSign;
	private Date createDate;
	private Date lastUpdate;
	private String remark;
	
	private String birthdays;
	private String createDates;
	private String lastUpdates;
	private String signs;
	private String sexs;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String account, String password, String nickName,
			String trueName, Integer sex, Date birthday, String icon,
			String phone, String email, String qq, String wechat, String sina, String info,
			Integer sign,  String token, String type,
			String typeId, String loginSign, Date createDate, Date lastUpdate, String remark) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.account = account;
		this.password = password;
		this.nickName = nickName;
		this.trueName = trueName;
		this.sex = sex;
		this.birthdays = simpleDateFormat.format(birthday);
		this.icon = icon;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.wechat = wechat;
		this.info = info;
		this.sign = sign;
		this.token = token;
		this.type = type;
		this.typeId = typeId;
		this.loginSign = loginSign;
		this.createDates = simpleDateFormat.format(createDate);
		this.lastUpdates = simpleDateFormat.format(lastUpdate);
		this.remark = remark;
		this.sexs = forSexs();
		this.signs = forSigns();
		this.sina = sina;
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
		this.sexs = forSexs();
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		this.birthdays = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(birthday);
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
		this.signs = forSigns();
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		this.createDates = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(createDate);
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
		this.lastUpdates = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(lastUpdate);
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSexs() {
		return sexs;
	}

	public String getSigns() {
		return signs;
	}

	public String getBirthdays() {
		return birthdays;
	}

	public void setBirthdays(String birthdays) {
		this.birthdays = birthdays;
	}

	public String getCreateDates() {
		return createDates;
	}

	public void setCreateDates(String createDates) {
		this.createDates = createDates;
	}

	public String getLastUpdates() {
		return lastUpdates;
	}

	public void setLastUpdates(String lastUpdates) {
		this.lastUpdates = lastUpdates;
	}

	public void setSigns(String signs) {
		this.signs = signs;
	}

	public void setSexs(String sexs) {
		this.sexs = sexs;
	}
	
	public String forSexs(){
		if (sex == 0) {
			return "女";
		} else if (sex == 1) {
			return "男";
		} else {
			return "不详";
		}
	}
	
	public String getSina() {
		return sina;
	}

	public void setSina(String sina) {
		this.sina = sina;
	}

	public String forSigns(){
		if (sign == 1 || sign == 2) {
			return "否";
		} else {
			return "是";
		}
	}
	
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getLoginSign() {
		return this.loginSign;
	}

	public void setLoginSign(String loginSign) {
		this.loginSign = loginSign;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", account=" + account
				+ ", password=" + password + ", nickName=" + nickName
				+ ", trueName=" + trueName + ", sex=" + sex + ", birthday="
				+ birthday + ", icon=" + icon + ", phone=" + phone + ", email="
				+ email + ", qq=" + qq + ", wechat=" + wechat + ", info="
				+ info + ", sign=" + sign + ", createDate=" + createDate
				+ ", lastUpdate=" + lastUpdate + ", remark=" + remark
				+ ", birthdays=" + birthdays + ", createDates=" + createDates
				+ ", lastUpdates=" + lastUpdates + ", signs=" + signs
				+ ", sexs=" + sexs + "]";
	}

}