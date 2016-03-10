package com.zehao.app.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zehao.constant.CONSTANT;
import com.zehao.util.Tool;

public class AppBaseAction extends ActionSupport {

	public static Logger logger = Logger.getLogger(AppBaseAction.class);

	private static final long serialVersionUID = 1L;
	
	public JSONObject json = null;

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

	/**
	 * 将收到的数据转为Json
	 * @param data
	 * @return
	 */
	public JSONObject getDataJson(String data) {
		if (!CONSTANT.NULL_STRING.equals(Tool.NVL(data))) {
			logger.info("---------->> APP DATA: " + data);
			return JSONObject.fromObject(data);
		} else {
			logger.info("---------->> APP DATA: null");
			return null;
		}
	}
	/**
	 * 处理接收到空数据
	 */
	public void nullData(){
		json = new JSONObject();
		json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
		json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
		appJson(json.toString());
	}
	/**
	 * 处理接收到的数据键值不匹配
	 */
	public void errorData(){
		json = new JSONObject();
		json.put(CONSTANT.MESSAGE, CONSTANT.CODE_174_TEXT);
		json.put(CONSTANT.ERRCODE, CONSTANT.CODE_174);
		appJson(json.toString());
	}
	/**
	 * 处理token错误
	 */
	public void errorToken(){
		json = new JSONObject();
		json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
		json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
		appJson(json.toString());
	}
	/**
	 * 处理必需的参数值为空错误
	 */
	public void notData(){
		json = new JSONObject();
		json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
		json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
		appJson(json.toString());
	}
}
