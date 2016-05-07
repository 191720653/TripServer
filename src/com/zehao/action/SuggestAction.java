package com.zehao.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Suggest;
import com.zehao.model.Users;
import com.zehao.service.ISuggestService;
import com.zehao.service.IUserService;
import com.zehao.util.Page;

public class SuggestAction extends BaseAction {

	private static final long serialVersionUID = 2276654514680024985L;
	private ISuggestService iSuggestService;
	private IUserService iUserService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Suggest> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Suggest");
	private String pram;
	private Suggest suggest;
	private int id;
	
	public String find(){
		if(pram==null){
			logger.info("----------" + "进入非条件查询" + "----------");
			pager = iSuggestService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			List<Users> users = new ArrayList<Users>();
			for(int i=0;i<pager.getResultList().size();i++){
				users.add(iUserService.findById(pager.getResultList().get(i).getUserId()));
			}
			logger.info("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			getRequest().put(CONSTANT.USERS, users);
			setForward("/admin/suggest_list.jsp");
			return Action.SUCCESS;
		}else{
			logger.info("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String delete(){
		logger.info("----------" + "进入删除建议" + "----------");
		iSuggestService.delete(id);
		setForward("/ZZHP/Suggest_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> title = new ArrayList<String>();
		String[] temp = {"建议Id","用户","建议内容","建议时间"}; 
		for(int i=0;i<temp.length;i++){
			title.add(temp[i]);
		}
		return title;
	}

	public ISuggestService getiSuggestService() {
		return iSuggestService;
	}

	public void setiSuggestService(ISuggestService iSuggestService) {
		this.iSuggestService = iSuggestService;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public Page<Suggest> getPager() {
		return pager;
	}

	public void setPager(Page<Suggest> pager) {
		this.pager = pager;
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

	public Suggest getSuggest() {
		return suggest;
	}

	public void setSuggest(Suggest suggest) {
		this.suggest = suggest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
