package com.zehao.interceptor;

import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zehao.action.TestAction;
import com.zehao.constant.CONSTANT;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("---------- 这是登录拦截器 ----------");
		
		// 获取域名
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		((Map<String, Object>)ActionContext.getContext().get("request")).put(CONSTANT.DOMAIN_SIGN, url.split("/")[2]);
		System.out.println("---------- 访问"+url+"站点 ----------");

		// 对LoginAction不做该项拦截
		String action = invocation.getInvocationContext().getName();
		if (TestAction.class.getSimpleName().equals(action)) {
			System.out
					.println("------ 对LoginAction不做登录拦截 ------");
			return invocation.invoke();
		}

		Map session = ActionContext.getContext().getSession();
		session.get(CONSTANT.LOGIN_SIGN);

		// 如果登陆过,则继续操作，否则返回登录页面
		if ( ""!= null) {
			System.out.println("------ " + " 已经登录 ------");
			return invocation.invoke();
		} else {
			System.out.println("------ 您还没有登录，返回登录！------");
			Map request = (Map) ActionContext.getContext().get("request");
			request.put(CONSTANT.MESSAGE, "");
			return CONSTANT.LOGERR;
		}
	}

}
