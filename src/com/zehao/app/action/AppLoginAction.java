package com.zehao.app.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;
import com.zehao.util.Guid;
import com.zehao.util.Tool;

public class AppLoginAction extends AppBaseAction {

	private static final long serialVersionUID = 3887959545614815426L;
	private IUserService iUserService;
	/**
	 * 用户账号
	 */
	private String user_account;
	/**
	 * 用户密码
	 */
	private String user_password;
	/**
	 * 用户token
	 */
	private String user_token;

	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * APP用户登录
	 * 
	 * @return
	 */
	public void login() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				user_account = json.getString(CONSTANT.ACCOUNT);
				user_password = json.getString(CONSTANT.PASSWORD);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(user_account)) 
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(user_password))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_172_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_172);
					appJson(json.toString());
					logger.info("---------- login fail, account or password can't ba null ----------");
				} else {
					// 校验账号、密码以及是否冻结
					String hql = "From Users Where account=? And password=?";
					List<Object> values = new ArrayList<Object>();
					values.add(user_account);
					values.add(user_password);
					Users user = iUserService.findUniqueByPropertys(hql, values);
					if (user == null) {
						json = new JSONObject();
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_173_TEXT);
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_173);
						appJson(json.toString());
						logger.info("---------- login fail, account or password may be wrong ----------");
					} else {
						if(CONSTANT.ACCOUNT_LOCK==user.getSign()){
							json = new JSONObject();
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_177);
							json.put(CONSTANT.MESSAGE, CONSTANT.CODE_177_TEXT);
							appJson(json.toString());
						}else{
							// 设置用户信息已经登录，分配token
							String token = Guid.produceGuid();
							
							user.setToken(token);
							user.setLoginSign(CONSTANT.LOGIN_SIGN_ON);
							iUserService.update(user);
							
							json = new JSONObject();
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							json.put(CONSTANT.USER_INFO, JSONObject.fromObject(user));
							appJson(json.toString());
							logger.info("---------- login success, turn to index page ----------");
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- login error: " + e.toString() + " ----------");
		}
	}

	/**
	 * 用户退出
	 * 
	 * @return
	 */
	public void logout() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {
				user_token = Tool.NVL(json.getString(CONSTANT.TOKEN));
				// 非空校验
				if (CONSTANT.NULL_STRING.equals(user_token)) {
					errorToken();
					logger.info("---------- logout fail, token can't ba null ----------");
				} else {
					// 检查用户是否存在
					Users user = iUserService.findUniqueByProperty("token", user_token);
					if (user == null) {
						errorToken();
						logger.info("---------- logout fail, token may be wrong ----------");
					} else {
						// 设置用户信息为注销状态，token为空
						user.setToken(CONSTANT.NULL_STRING);
						user.setLoginSign(CONSTANT.LOGIN_SIGN_OFF);
						iUserService.update(user);
						
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						appJson(json.toString());
						logger.info("---------- logout success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- logout error: " + e.toString() + " ----------");
		}
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

}
