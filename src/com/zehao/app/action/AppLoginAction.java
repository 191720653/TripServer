package com.zehao.app.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;

public class AppLoginAction extends AppBaseAction {

	private static final long serialVersionUID = 3887959545614815426L;
	private IUserService iUserService;
	private JSONObject json = null;
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
		System.out.println("jinlaile: " + data);
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
				json = new JSONObject();
				json.put(CONSTANT.MESSAGE, "非法数据！");
				appJson(json.toString());
			} else {

				user_account = json.getString(CONSTANT.ACCOUNT);
				user_password = json.getString(CONSTANT.PASSWORD);
				user_token = json.getString(CONSTANT.TOKEN);

				// 非空校验
				if (user_account == null || user_account.length() == 0
						|| user_password == null || user_password.length() == 0) {
					json.put(CONSTANT.MESSAGE, "账号密码不能为空！");
					logger.info("---------- login fail, account or password can't ba null ----------");
					appJson(json.toString());
				} else {
					// 校验账号、密码以及身份
					String hql = "From Users Where account=? And password=? And sign=?";
					List<Object> values = new ArrayList<Object>();
					values.add(user_account);
					values.add(user_password);
					values.add(CONSTANT.ROLE_SIGN_ADMIN);
					Users user = iUserService
							.findUniqueByPropertys(hql, values);
					if (user == null) {
						json.put(CONSTANT.MESSAGE, "账号密码错误！");
						appJson(json.toString());
					} else {
						// 设置用户信息已经登录，分配token
						logger.info("---------- login success, turn to index page ----------");
						appJson(json.toString());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			json = new JSONObject();
			json.put(CONSTANT.MESSAGE, "非法数据，获取不到值！");
			appJson(json.toString());
		}

	}

	/**
	 * 后台用户退出
	 * 
	 * @return
	 */
	public String logout() {
		// 清除session
		try {
			Set<String> set = getSession().keySet();
			Iterator<String> iterator = set.iterator();
			while (iterator.hasNext()) {
				getSession().remove(iterator.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			getSession().clear();
		}
		logger.info("---------- 清除session成功，返回登录页面 ----------");
		return Action.LOGIN;
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
