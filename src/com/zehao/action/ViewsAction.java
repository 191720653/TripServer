package com.zehao.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Views;
import com.zehao.model.Village;
import com.zehao.service.IViewsService;
import com.zehao.service.IVillageService;
import com.zehao.util.FileUtil;
import com.zehao.util.Page;

public class ViewsAction extends BaseAction {

	private static final long serialVersionUID = -7749299223425979759L;
	private IViewsService iViewsService;
	private IVillageService iVillageService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Views> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Views");
	private String pram;
	private Views views;
	private int id;
	
	public String find(){
		if(pram==null){
			logger.info("----------" + "进入非条件查询" + "----------");
			pager = iViewsService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			List<Village> villages = iVillageService.getAll();
			logger.info("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			getRequest().put(CONSTANT.VILLAGES, villages);
			setForward("/admin/views_list.jsp");
			return Action.SUCCESS;
		}else{
			logger.info("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String add(){
		logger.info("----------" + "进入增加景点" + "----------");
		String path = saveFile();
		views.setViewLogo(path);
		views.setCreateDate(new Date(System.currentTimeMillis()));
		iViewsService.save(views);
		setForward("/ZZHP/Views_findAction.action");
		return CONSTANT.REDIRECT;
	}
	
	public String update(){
		logger.info("----------" + "进入更新景点" + "----------");
		logger.info(views.getRemark() + views.getViewId());
		String path = saveFile();
		views.setViewLogo(path);
		iViewsService.update(views);
		setForward("/ZZHP/Views_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public String delete(){
		logger.info("----------" + "进入删除景点" + "----------");
		iViewsService.delete(id);
		setForward("/ZZHP/Views_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> title = new ArrayList<String>();
		String[] temp = {"景区Id","村子Id","名称","地址","导语","简介","标志","开放时间","票价","联系电话","点赞数","有子景点","景区Id","创建日期","备注","人物活动","社会活动"}; 
		for(int i=0;i<temp.length;i++){
			title.add(temp[i]);
		}
		return title;
	}

	public IViewsService getiViewsService() {
		return iViewsService;
	}

	public void setiViewsService(IViewsService iViewsService) {
		this.iViewsService = iViewsService;
	}

	public IVillageService getiVillageService() {
		return iVillageService;
	}

	public void setiVillageService(IVillageService iVillageService) {
		this.iVillageService = iVillageService;
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

	public Views getViews() {
		return views;
	}

	public void setViews(Views views) {
		this.views = views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// 文件上传
	private File image; //上传的文件
    private String imageFileName; //文件名称
    private String imageContentType; //文件类型
    
    public String saveFile(){
        if (image != null) {
        	String realpath = ServletActionContext.getServletContext().getRealPath("/photoes");
            logger.info("realpath: " + realpath);
            String name = System.currentTimeMillis() + imageFileName.substring(imageFileName.lastIndexOf("."));
            StringBuffer path = new StringBuffer("./photoes/").append(name);
            File savefile = new File(new File(realpath), name);
            logger.info(path.toString());
            FileUtil.copy(image, savefile);
            return path.toString();
        }else
        	return views.getViewLogo();
    }

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
