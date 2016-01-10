package com.zehao.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;
import com.zehao.util.Page;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private IUserService iUserService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Users> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Users");
	private String pram;
	private int id;

	public String find(){
		if(pram==null){
			System.out.println("----------" + "进入非条件查询" + "----------");
			pager = iUserService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			System.out.println("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getUserTitle());
			setForward("/admin/user_list.jsp");
			return Action.SUCCESS;
		}else{
			System.out.println("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}

	public String delete(){
		System.out.println("----------" + "进入删除用户" + "----------");
		iUserService.delete(id);
		setForward("/ZZHP/User_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
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

	private List<String> getUserTitle(){
		List<String> userTitle = new ArrayList<String>();
		String[] temp = {"用户Id","账号","密码","昵称","真实姓名","性别","生日","头像","电话","邮箱","QQ","微信","简介","是否冻结","创建日期","更新日期","备注"}; 
		for(int i=0;i<temp.length;i++){
			userTitle.add(temp[i]);
		}
		return userTitle;
	}

}
