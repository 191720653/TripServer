package com.zehao.app.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;
import com.zehao.util.FileUtil;
import com.zehao.util.Tool;

public class AppSignInAction extends AppBaseAction {

	private static final long serialVersionUID = 3887959545614815426L;
	private IUserService iUserService;
	/**
	 * 用户账号
	 */
	private String account;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户头像
	 */
	private String icon;
	/**
	 * 用户性别
	 */
	private String sex;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 用户备注
	 */
	private String remark;
	/**
	 * 用户类型
	 */
	private String type;
	/**
	 * 类型Id
	 */
	private String typeId;

	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * APP用户注册
	 * 
	 * @return
	 */
	public void register() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				account = json.getString(CONSTANT.ACCOUNT);
				password = json.getString(CONSTANT.PASSWORD);
				icon = json.getString(CONSTANT.ICON);
				sex = json.getString(CONSTANT.SEX);
				nickName = json.getString(CONSTANT.NICK_NAME);
				remark = json.getString(CONSTANT.REMARK);
				type = json.getString(CONSTANT.USER_TYPE);
				typeId = json.getString(CONSTANT.USER_TYPE_ID);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(account))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(password))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(type))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(typeId))) {
					notData();
					logger.info("---------- sign in fail, account or password can't be null ----------");
				} else {
					// 校验账号、密码以及身份
					String hql = "From Users Where account=? Or typeId=?";
					List<Object> values = new ArrayList<Object>();
					values.add(account);
					values.add(typeId);
					Users user = iUserService.findUniqueByPropertys(hql, values);
					if (user != null) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_176_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_176);
						appJson(json.toString());
						logger.info("---------- sign in fail, account has been used ----------");
					} else {
						// 设置用户信息
						user = new Users();
						user.setAccount(account);
						user.setPassword(password);
						icon = saveFile();
						user.setIcon(icon);
						user.setNickName(nickName);
						user.setSexs(sex);
						// user.setRemark(remark);
						user.setInfo(remark);
						user.setType(type);
						user.setTypeId(typeId);
						user.setCreateDate(new Date());
						user.setLoginSign(CONSTANT.LOGIN_SIGN_OFF);
						user.setSign(CONSTANT.ROLE_SIGN_USER);
						Integer id = (Integer) iUserService.save(user);

						user = iUserService.findById(id);
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						json.put(CONSTANT.USER_INFO, JSONObject.fromObject(user));
						appJson(json.toString());
						logger.info("---------- sign in success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- sign in error: " + e.toString() + " ----------");
		}
	}

	/**
	 * 第三方Id检查
	 * 
	 * @return
	 */
	public void checkId() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {
				typeId = Tool.NVL(json.getString(CONSTANT.USER_TYPE_ID));
				// 非空校验
				if (CONSTANT.NULL_STRING.equals(typeId)) {
					notData();
					logger.info("---------- checkId fail, typeId can't be null ----------");
				} else {
					// 检查用户是否存在
					Users user = iUserService.findUniqueByProperty("typeId", typeId);
					if (user == null) {
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_NOT);
						appJson(json.toString());
						logger.info("---------- checkId not found, turn to sign in page ----------");
					} else {
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_HAS);
						json.put(CONSTANT.USER_INFO, user);
						appJson(json.toString());
						logger.info("---------- checkId success, turn to login page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- checkId error: " + e.toString() + " ----------");
		}
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	// 文件上传
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public String saveFile() {
		if (image != null) {
			String realpath = ServletActionContext.getServletContext().getRealPath("/icons");
			logger.info("realpath: " + realpath);
			String name = System.currentTimeMillis() + imageFileName.substring(imageFileName.lastIndexOf("."));
			StringBuffer path = new StringBuffer("./icons/").append(name);
			File savefile = new File(new File(realpath), name);
			logger.info(path.toString());
			FileUtil.copy(image, savefile);
			return path.toString();
		}
		logger.info("---------- sign in image != null: " + image != null + " ----------");
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
