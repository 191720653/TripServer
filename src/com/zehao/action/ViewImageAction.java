package com.zehao.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.ViewImage;
import com.zehao.service.IViewImageService;
import com.zehao.util.Page;

public class ViewImageAction extends BaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private IViewImageService iViewImageService;
	/**
	 * 存放分页查询结果
	 */
	private Page<ViewImage> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From ViewImage");
	private String pram;
	private int id;

	public String find(){
		if(pram==null){
			System.out.println("----------" + "进入非条件查询" + "----------");
			pager = iViewImageService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			System.out.println("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			setForward("/admin/viewimage_list.jsp");
			return Action.SUCCESS;
		}else{
			System.out.println("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}

	public String delete(){
		System.out.println("----------" + "进入删除相片" + "----------");
		iViewImageService.delete(id);
		setForward("/ZZHP/ViewImage_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}

	private List<String> getTitle(){
		List<String> Title = new ArrayList<String>();
		String[] temp = {"相片Id","景区Id","用户Id","图片信息","图片URL","创建日期","备注"}; 
		for(int i=0;i<temp.length;i++){
			Title.add(temp[i]);
		}
		return Title;
	}

	public IViewImageService getiViewImageService() {
		return iViewImageService;
	}

	public void setiViewImageService(IViewImageService iViewImageService) {
		this.iViewImageService = iViewImageService;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
