package com.zehao.app.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.model.ViewImage;
import com.zehao.service.IUserService;
import com.zehao.service.IViewImageService;
import com.zehao.util.FileUtil;
import com.zehao.util.Tool;

/**
 * < TODO：用户获取相册 >
 * 
 * @ClassName: AppUserAction
 * @author pc-hao
 * @date 2016年3月19日 下午2:14:06
 * @version V 1.0
 */
public class AppPictureAction extends AppBaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private IUserService iUserService;
	private IViewImageService iViewImageService;

	private String data;
	private String token;
	private int count;
	private JSONArray url;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public IViewImageService getiViewImageService() {
		return iViewImageService;
	}

	public void setiViewImageService(IViewImageService iViewImageService) {
		this.iViewImageService = iViewImageService;
	}

	public void getPictures() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				token = json.getString(CONSTANT.TOKEN);
				count = json.getInt(CONSTANT.PICTURE_COUNT);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(token)) 
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(count + ""))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getPictures fail, token can't be null ----------");
				} else {
					// 检查token是否有效
					Users user = iUserService.findUniqueByProperty("token", token);
					if (null == user) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						appJson(json.toString());
						logger.info("---------- getPictures fail, token is useless ----------");
					} else {
						// 获取用户的相册列表
						List<String> urls = iViewImageService.getUrl(2, user.getUserId());
						if(count!=urls.size()){
							json = new JSONObject();
							json.put(CONSTANT.PICTURES, urls);
							json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_HAS);// 相册需要更新
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							appJson(json.toString());
							logger.info("---------- getPictures success, turn to index page ----------");
						} else {
							json = new JSONObject();
							json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_NOT);// 相册没有更新
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							appJson(json.toString());
							logger.info("---------- getPictures success, turn to index page ----------");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getPictures error: " + e.toString() + " ----------");
		}
	}

	public void uploadPicture() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				token = json.getString(CONSTANT.TOKEN);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(token))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- uploadPicture fail, token can't be null ----------");
				} else {
					// 检查用户token是否有效
					Users user = iUserService.findUniqueByProperty("token", token);
					if (null == user) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						appJson(json.toString());
					} else {
						String path = saveFile();
						if(path==null){
							json = new JSONObject();
							json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
							appJson(json.toString());
						} else {
							ViewImage viewImage = new ViewImage();
							viewImage.setImageUrl(path);
							viewImage.setCreateDate(new Date());
							viewImage.setUsers(user);
							iViewImageService.save(viewImage);
							json = new JSONObject();
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							appJson(json.toString());
							logger.info("---------- uploadPicture success, turn to index page ----------");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- uploadPicture error: " + e.toString() + " ----------");
		}
	}
	
	public void deletePicture(){
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				token = json.getString(CONSTANT.TOKEN);
				url = json.getJSONArray(CONSTANT.PICTURES);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(token)) || url == null || url.size() == 0) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- deletePicture fail, token can't be null ----------");
				} else {
					// 检查用户token是否有效
					Users user = iUserService.findUniqueByProperty("token", token);
					if (null == user) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						appJson(json.toString());
					} else {
						ViewImage viewImage = null;
						for(int i=0;i<url.size();i++){
							viewImage = iViewImageService.findUniqueByProperty("imageUrl", url.get(i));
							if(viewImage!=null)iViewImageService.delete(viewImage.getImageId());
						}
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						appJson(json.toString());
						logger.info("---------- deletePicture success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- deletePicture error: " + e.toString() + " ----------");
		}
	}

	// 文件上传
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public String saveFile() {
		if (image != null) {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/icons");
			logger.info("realpath: " + realpath);
			String name = System.currentTimeMillis()
					+ imageFileName.substring(imageFileName.lastIndexOf("."));
			StringBuffer path = new StringBuffer("./icons/").append(name);
			File savefile = new File(new File(realpath), name);
			logger.info(path.toString());
			FileUtil.copy(image, savefile);
			return path.toString();
		}
		logger.info("---------- uploadPicture image != null: " + image != null + " ----------");
		return null;
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
