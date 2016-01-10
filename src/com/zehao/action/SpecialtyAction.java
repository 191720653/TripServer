package com.zehao.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Specialty;
import com.zehao.service.ISpecialtyService;
import com.zehao.util.Page;

public class SpecialtyAction extends BaseAction {

	private static final long serialVersionUID = -7749299223425979759L;
	private ISpecialtyService iSpecialtyService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Specialty> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Specialty");
	private String pram;
	private Specialty specialty;
	private int id;
	
	public String find(){
		if(pram==null){
			System.out.println("----------" + "进入非条件查询" + "----------");
			pager = iSpecialtyService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			System.out.println("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			setForward("/admin/specialty_list.jsp");
			return Action.SUCCESS;
		}else{
			System.out.println("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String add(){
		System.out.println("----------" + "进入增加店铺" + "----------");
		specialty.setCreateDate(new Date(System.currentTimeMillis()));
		iSpecialtyService.save(specialty);
		setForward("/ZZHP/Specialty_findAction.action");
		return CONSTANT.REDIRECT;
	}
	
	public String update(){
		System.out.println("----------" + "进入更新店铺" + "----------");
		System.out.println(specialty.getRemark() + specialty.getSpecialId());
		iSpecialtyService.update(specialty);
		setForward("/ZZHP/Specialty_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public String delete(){
		System.out.println("----------" + "进入删除店铺" + "----------");
		iSpecialtyService.delete(id);
		setForward("/ZZHP/Specialty_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> title = new ArrayList<String>();
		String[] temp = {"特产Id","名称","简介","地址","创建日期","备注"}; 
		for(int i=0;i<temp.length;i++){
			title.add(temp[i]);
		}
		return title;
	}

	public ISpecialtyService getiSpecialtyService() {
		return iSpecialtyService;
	}

	public void setiSpecialtyService(ISpecialtyService iSpecialtyService) {
		this.iSpecialtyService = iSpecialtyService;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPram() {
		return pram;
	}

	public void setPram(String pram) {
		this.pram = pram;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
