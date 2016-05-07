package com.zehao.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Other;
import com.zehao.service.IOtherService;
import com.zehao.util.FileUtil;
import com.zehao.util.Page;

public class OthersAction extends BaseAction {

	private static final long serialVersionUID = -7749299223425979759L;
	private IOtherService iOtherService;
	/**
	 * 存放分页查询结果
	 */
	private Page<Other> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From Other");
	private String pram;
	private Other other;
	private int id;
	private int index;
	
	public String find(){
		if(pram==null){
			logger.info("----------" + "进入非条件查询" + "----------");
			pager = iOtherService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			logger.info("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			setForward("/admin/others_list.jsp");
			return Action.SUCCESS;
		}else{
			logger.info("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String add(){
		logger.info("----------" + "进入增加其它信息" + "----------");
		String path = saveFile();
		other.setLogo(path);
		other.setCreateData(new Date(System.currentTimeMillis()));
		iOtherService.save(other);
		setForward("/ZZHP/Other_findAction.action");
		return CONSTANT.REDIRECT;
	}
	
	public String updateUrls(){
		logger.info("----------" + "进入更新其它信息" + "----------");
		Other temp = iOtherService.findById(id);
		JSONArray urls = null;
		if(temp.getUrls()!=null&&temp.getUrls().length()!=0){
			urls = JSONArray.fromObject(temp.getUrls());
			if(urls.size()<3){
				urls.add(saveFile());
			}
		}else{
			urls = new JSONArray();
			urls.add(saveFile());
		}
		temp.setUrls(urls.toString());
		iOtherService.update(temp);
		setForward("/ZZHP/Other_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public String deleteUrl(){
		logger.info("----------" + "进入更新其它url信息" + "----------");
		Other temp = iOtherService.findById(id);
		JSONArray urls = null;
		if(temp.getUrls()!=null&&temp.getUrls().length()!=0){
			urls = JSONArray.fromObject(temp.getUrls());
			if(urls.size()>=index){
				urls.remove(index);
				temp.setUrls(urls.toString());
				iOtherService.update(temp);
			}
		}
		setForward("/ZZHP/Other_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public void getUrls(){
		logger.info("----------" + "进入获取其它信息" + "----------");
		Other temp = iOtherService.findById(id);
		if(temp.getUrls()!=null&&temp.getUrls().length()>0){
			ajaxJson(temp.getUrls());
		} else ajaxJson("0");
	}
	
	public String update(){
		logger.info("----------" + "进入更新其它信息" + "----------");
		String path = saveFile();
		other.setLogo(path);
		iOtherService.update(other);
		setForward("/ZZHP/Other_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public String delete(){
		logger.info("----------" + "进入删除其它信息" + "----------");
		iOtherService.delete(id);
		setForward("/ZZHP/Other_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> title = new ArrayList<String>();
		String[] temp = {"Id","名称","介绍","图标","赞数","类型","备注"}; 
		for(int i=0;i<temp.length;i++){
			title.add(temp[i]);
		}
		return title;
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
	
	public IOtherService getiOtherService() {
		return iOtherService;
	}

	public void setiOtherService(IOtherService iOtherService) {
		this.iOtherService = iOtherService;
	}

	public Page<Other> getPager() {
		return pager;
	}

	public void setPager(Page<Other> pager) {
		this.pager = pager;
	}

	public Other getOther() {
		return other;
	}

	public void setOther(Other other) {
		this.other = other;
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
        	return other.getLogo();
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
