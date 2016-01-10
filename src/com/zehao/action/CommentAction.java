package com.zehao.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Comment;
import com.zehao.service.ICommentService;
import com.zehao.util.Page;

public class CommentAction extends BaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private ICommentService iCommentService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Comment> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Comment");
	private String pram;
	private int id;

	public String find(){
		if(pram==null){
			System.out.println("----------" + "进入非条件查询" + "----------");
			pager = iCommentService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			System.out.println("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			setForward("/admin/comment_list.jsp");
			return Action.SUCCESS;
		}else{
			System.out.println("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String delete(){
		System.out.println("----------" + "进入删除评论" + "----------");
		iCommentService.delete(id);
		setForward("/ZZHP/Comment_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> Title = new ArrayList<String>();
		String[] temp = {"评论Id","用户","景区","名店","特产","内容","时间","分数","备注"}; 
		for(int i=0;i<temp.length;i++){
			Title.add(temp[i]);
		}
		return Title;
	}

	public ICommentService getiCommentService() {
		return iCommentService;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
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
