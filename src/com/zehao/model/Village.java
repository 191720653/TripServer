package com.zehao.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Village entity. @author MyEclipse Persistence Tools
 */

public class Village implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8506760589682787389L;
	private Integer villageId;
	private String villageName;
	private String villageAddress;
	private String villageInfo;
	private String villageLogo;
	private String historyRecord;
	private String villageStory;
	private Date createDate;
	private String remark;
	private Set<Views> viewses = new HashSet<Views>(0);

	// Constructors

	/** default constructor */
	public Village() {
	}

	/** full constructor */
	public Village(String villageName, String villageAddress,
			String villageInfo, String villageLogo, String historyRecord,
			String villageStory, Date createDate, String remark, Set<Views> viewses) {
		this.villageName = villageName;
		this.villageAddress = villageAddress;
		this.villageInfo = villageInfo;
		this.villageLogo = villageLogo;
		this.historyRecord = historyRecord;
		this.villageStory = villageStory;
		this.createDate = createDate;
		this.remark = remark;
		this.viewses = viewses;
	}

	// Property accessors

	public Integer getVillageId() {
		return this.villageId;
	}

	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
	}

	public String getVillageName() {
		return this.villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getVillageAddress() {
		return this.villageAddress;
	}

	public void setVillageAddress(String villageAddress) {
		this.villageAddress = villageAddress;
	}

	public String getVillageInfo() {
		return this.villageInfo;
	}

	public void setVillageInfo(String villageInfo) {
		this.villageInfo = villageInfo;
	}

	public String getVillageLogo() {
		return this.villageLogo;
	}

	public void setVillageLogo(String villageLogo) {
		this.villageLogo = villageLogo;
	}

	public String getHistoryRecord() {
		return this.historyRecord;
	}

	public void setHistoryRecord(String historyRecord) {
		this.historyRecord = historyRecord;
	}

	public String getVillageStory() {
		return this.villageStory;
	}

	public void setVillageStory(String villageStory) {
		this.villageStory = villageStory;
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

	public Set<Views> getViewses() {
		return this.viewses;
	}

	public void setViewses(Set<Views> viewses) {
		this.viewses = viewses;
	}

}