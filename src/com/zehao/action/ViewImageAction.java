package com.zehao.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.ViewImage;
import com.zehao.model.Views;
import com.zehao.model.Village;
import com.zehao.service.IViewImageService;
import com.zehao.service.IViewsService;
import com.zehao.service.IVillageService;
import com.zehao.util.FileUtil;
import com.zehao.util.Page;

public class ViewImageAction extends BaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private IViewImageService iViewImageService;
	private IVillageService iVillageService;
	private IViewsService iViewsService;
	/**
	 * 存放分页查询结果
	 */
	private Page<ViewImage> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From ViewImage vi Where vi.users.userId is null");
	private String pram;
	private int id;
	private ViewImage viewImage;

	public String find(){
		if(pram==null){
			logger.info("----------" + "进入非条件查询" + "----------");
			pager = iViewImageService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			logger.info("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			List<Village> villages = iVillageService.getAll();
			getRequest().put(CONSTANT.VILLAGES, villages);
			List<Views> views = iViewsService.getAll();
			getRequest().put(CONSTANT.VIEWS, views);
			setForward("/admin/viewimage_list.jsp");
			return Action.SUCCESS;
		}else{
			logger.info("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String add() {
		logger.info("----------" + "进入图片" + "----------");
		viewImage.setCreateDate(new Date(System.currentTimeMillis()));
		if(viewImage.getViews().getViewId()!=null){
			viewImage.setVillage(null);
		}else{
			viewImage.setViews(null);
		}
		String path = saveFile();
		viewImage.setImageUrl(path);
		viewImage.setUsers(null);
		iViewImageService.save(viewImage);
		setForward("/ZZHP/ViewImage_findAction.action");
		return CONSTANT.REDIRECT;
	}
	
	public String update() {
		logger.info("----------" + "进入更新村庄" + "----------");
		String path = saveFile();
		viewImage.setImageUrl(path);
		if(viewImage.getViews().getViewId()!=null){
			viewImage.setVillage(null);
		}else{
			viewImage.setViews(null);
		}
		viewImage.setUsers(null);
		iViewImageService.update(viewImage);
		setForward("/ZZHP/ViewImage_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}

	public String delete(){
		logger.info("----------" + "进入删除相片" + "----------");
		iViewImageService.delete(id);
		setForward("/ZZHP/ViewImage_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}

	private List<String> getTitle(){
		List<String> Title = new ArrayList<String>();
		String[] temp = {"相片Id","景区Id","用户Id","区域Id","图片信息","图片URL","创建日期","备注"}; 
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

	public IVillageService getiVillageService() {
		return iVillageService;
	}

	public void setiVillageService(IVillageService iVillageService) {
		this.iVillageService = iVillageService;
	}

	public IViewsService getiViewsService() {
		return iViewsService;
	}

	public void setiViewsService(IViewsService iViewsService) {
		this.iViewsService = iViewsService;
	}

	public ViewImage getViewImage() {
		return viewImage;
	}

	public void setViewImage(ViewImage viewImage) {
		this.viewImage = viewImage;
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
	    	return viewImage.getImageUrl();
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
