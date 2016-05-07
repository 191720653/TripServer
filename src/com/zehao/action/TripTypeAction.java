package com.zehao.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.TripType;
import com.zehao.service.ITripTypeService;
import com.zehao.util.FileUtil;
import com.zehao.util.Page;

public class TripTypeAction extends BaseAction {

	private static final long serialVersionUID = 2063991321140571969L;
	private ITripTypeService iTripTypeService;
	/**
	 * 存放分页查询结果
	 */
	private Page<TripType> pager = null;
	/**
	 * 存放分页查询条件
	 */
	private List<Object> values = null;
	private int pages = 0;
	private StringBuffer hql = new StringBuffer("From TripType");
	private String pram;
	private TripType tripType;
	private int id;
	// private int typeId;
	
	public String find(){
		if(pram==null){
			logger.info("----------" + "进入非条件查询" + "----------");
			pager = iTripTypeService.findPageByHQL(pages, CONSTANT.PAGE_SIZE, hql.toString(), values);
			logger.info("----------" + pager.toString() + "----------");
			getRequest().put(CONSTANT.PAGER, pager);
			getRequest().put(CONSTANT.TITLE_LIST, getTitle());
			setForward("/admin/triptype_list.jsp");
			return Action.SUCCESS;
		}else{
			logger.info("----------" + "进入条件查询" + "----------");
			// 把条件放进pram
			getRequest().put(CONSTANT.PRAM, JSONObject.fromObject("{'123':'456','qwe':'asd'}"));
			return Action.SUCCESS;
		}
	}
	
	public String add(){
		logger.info("----------" + "进入增加旅游类型" + "----------");
		String path = saveFile();
		tripType.setTypeLogo(path);
		iTripTypeService.save(tripType);
		setForward("/ZZHP/TripType_findAction.action");
		return CONSTANT.REDIRECT;
	}
	
	public String update(){
		logger.info("----------" + "进入更新旅游类型" + "----------");
		logger.info(tripType.getRemark() + tripType.getTypeId());
		String path = saveFile();
		if(path!=null){
			tripType.setTypeLogo(path);
		}
		iTripTypeService.update(tripType);
		setForward("/ZZHP/TripType_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	public String delete(){
		logger.info("----------" + "进入删除旅游类型" + "----------");
		iTripTypeService.delete(id);
		setForward("/ZZHP/TripType_findAction.action?pages=" + pages);
		return CONSTANT.REDIRECT;
	}
	
	private List<String> getTitle(){
		List<String> title = new ArrayList<String>();
		String[] temp = {"类型Id","名称","图标","备注"}; 
		for(int i=0;i<temp.length;i++){
			title.add(temp[i]);
		}
		return title;
	}

	public ITripTypeService getiTripTypeService() {
		return iTripTypeService;
	}

	public void setiTripTypeService(ITripTypeService iTripTypeService) {
		this.iTripTypeService = iTripTypeService;
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

	public TripType getTripType() {
		return tripType;
	}

	public void setTripType(TripType tripType) {
		this.tripType = tripType;
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
        	return tripType.getTypeLogo();
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
