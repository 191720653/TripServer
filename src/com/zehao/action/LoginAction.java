package com.zehao.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.zehao.constant.CONSTANT;
import com.zehao.model.Users;
import com.zehao.service.IUserService;

public class LoginAction extends BaseAction {

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
	 * 后台用户登录
	 * 
	 * @return
	 */
	public String login() {
		// 非空校验
		if (user_account == null || user_account.length() == 0
				|| user_password == null || user_password.length() == 0) {
			getRequest().put(CONSTANT.MESSAGE, "账号密码不能为空！");
			logger.info("---------- 登录失败，账号或密码为空 ----------");
			return Action.LOGIN;
		}
		// 校验账号、密码以及身份
		String hql = "From Users Where account=? And password=? And sign=?";
		List<Object> values = new ArrayList<Object>();
		values.add(user_account);
		values.add(user_password);
		values.add(CONSTANT.ROLE_SIGN_ADMIN);
		Users user = iUserService.findUniqueByPropertys(hql, values);
		if (user == null) {
			getRequest().put(CONSTANT.MESSAGE, "账号或密码错误！");
			logger.info("---------- 登录失败，账号或密码错误 ----------");
			return Action.LOGIN;
		}
		getSession().put(CONSTANT.LOGIN_SIGN, user);
		logger.info("---------- 登录成功，跳转到后台管理页面 ----------");
		setForward("/admin/index.jsp");
		return Action.SUCCESS;
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
