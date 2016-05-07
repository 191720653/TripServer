package com.zehao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

/**
 * Other entity. @author MyEclipse Persistence Tools
 */

public class Other implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -8997032434640357732L;
	private Integer id;
	private String name;
	private String info;
	private String logo;
	private Integer likeNum;
	private String urls;
	private String type;
	private Date createData;
	private String remark;
	private String text;
	private String record;

	private List<String> url;
	
	// Constructors

	/** default constructor */
	public Other() {
	}

	/** full constructor */
	public Other(String name, String info, String logo, Integer likeNum,
			String urls, String type, Date createData, String remark,
			String text, String record) {
		this.name = name;
		this.info = info;
		this.logo = logo;
		this.likeNum = likeNum;
		this.urls = urls;
		this.type = type;
		this.createData = createData;
		this.remark = remark;
		this.text = text;
		this.record = record;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getLikeNum() {
		return this.likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	public String getUrls() {
		return this.urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateData() {
		return this.createData;
	}

	public void setCreateData(Date createData) {
		this.createData = createData;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRecord() {
		return this.record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public List<String> getUrl() {
		url = new ArrayList<String>();
		if(urls!=null&&urls.length()>0){
			JSONArray json = JSONArray.fromObject(urls);
			for(int i=0;i<json.size();i++){
				url.add(json.getString(i));
			}
		}
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

}