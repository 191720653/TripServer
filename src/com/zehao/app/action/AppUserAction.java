package com.zehao.app.action;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;
import com.zehao.util.FileUtil;
import com.zehao.util.Tool;

/**
 * < TODO：用户修改我的信息 >
 * 
 * @ClassName: AppUserAction
 * @author pc-hao
 * @date 2016年3月19日 下午2:14:06
 * @version V 1.0
 */
public class AppUserAction extends AppBaseAction {

	private static final long serialVersionUID = 3554804586311210883L;
	private IUserService iUserService;

	private String data;
	private String token;
	private Users user;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public void updateUserInfo() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				token = json.getString(CONSTANT.TOKEN);
				account = json.getString(CONSTANT.ACCOUNT);
				password = json.getString(CONSTANT.PASSWORD);
				icon = json.getString(CONSTANT.ICON);
				sex = json.getString(CONSTANT.SEX);
				nickName = json.getString(CONSTANT.NICK_NAME);
				remark = json.getString(CONSTANT.REMARK);
				type = json.getString(CONSTANT.USER_TYPE);
				typeId = json.getString(CONSTANT.USER_TYPE_ID);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(token))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(account))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(password))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(type))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(typeId))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- updateUserInfo fail, token or userinfo can't be null ----------");
				} else {
					// 检查token是否存在
					user = iUserService.findUniqueByProperty("token", token);
					if (null == user) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						appJson(json.toString());
						logger.info("---------- updateUserInfo fail, token is useless ----------");
					} else {
						String path = saveFile();
						if (path != null) {
							user.setIcon(path);
						}
						user.setAccount(account);
						user.setPassword(password);
						user.setNickName(nickName);
						user.setSexs(sex);
						user.setInfo(remark);
						user.setLastUpdate(new Date());
						iUserService.update(user);
						json = new JSONObject();
						json.put(CONSTANT.USER_INFO, iUserService.findById(user.getUserId()));
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						appJson(json.toString());
						logger.info("---------- updateUserInfo success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- updateUserInfo error: " + e.toString() + " ----------");
		}
	}

	public void checkToken() {
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
					logger.info("---------- checkToken fail, token or user can't be null ----------");
				} else {
					// 检查token是否存在
					if (null == iUserService.findUniqueByProperty("token", token)) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						appJson(json.toString());
						logger.info("---------- checkToken fail, token is useless ----------");
					} else {
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						appJson(json.toString());
						logger.info("---------- checkToken success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- checkToken error: " + e.toString() + " ----------");
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
		logger.info("---------- updateUserInfo image != null: " + image != null + " ----------");
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
}
