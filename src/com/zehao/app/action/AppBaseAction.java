package com.zehao.app.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zehao.constant.CONSTANT;
import com.zehao.util.Tool;

public class AppBaseAction extends ActionSupport {

	public static Logger logger = Logger.getLogger(AppBaseAction.class);

	private static final long serialVersionUID = 1L;

	private String forward = null;

	private Map<String, Object> session = ActionContext.getContext()
			.getSession();

	@SuppressWarnings("unchecked")
	private Map<String, Object> request = (Map<String, Object>) ActionContext
			.getContext().get(CONSTANT.REQUEST);

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	/**
	 * app输出，返回null
	 * 
	 * @param content - 输出内容
	 * @return type - 输出类型
	 */
	public String app(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(type + ";charset=utf-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
			logger.info("---------->> SERVER DATA: " + content);
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("---------- return data error：" + e.toString() + " ----------");
		}
		return null;
	}

	/**
	 * app输出文本，返回null
	 * 
	 * @param test - 文本内容
	 * @return String - String
	 */
	public String appText(String text) {
		return app(text, "text/plain");
	}

	/**
	 * app输出HTML，返回null
	 * 
	 * @param html - html内容
	 * @return String - String
	 */
	public String appHtml(String html) {
		return app(html, "text/html");
	}

	/**
	 * app输出XML，返回null
	 * 
	 * @param xml - xml
	 * @return String - String
	 */
	public String appXml(String xml) {
		return app(xml, "text/xml");
	}

	/**
	 * 根据字符串输出JSON，返回null
	 * 
	 * @param jsonString - 字符串内容
	 * @return String - 处理过后的String
	 */
	public String appJson(String jsonString) {
		return app(jsonString, "text/html");
	}

	public JSONObject getDataJson(String data) {
		if (!CONSTANT.NULL_STRING.equals(Tool.NVL(data))) {
			logger.info("---------->> APP DATA: " + data);
			return JSONObject.fromObject(data);
		} else {
			logger.info("---------->> APP DATA: null");
			return null;
		}
	}
}
