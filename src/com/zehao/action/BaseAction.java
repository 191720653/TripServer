package com.zehao.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zehao.constant.CONSTANT;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String forward = null;
	
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get(CONSTANT.REQUEST);

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
     * AJAX输出，返回null  
     * @param content - 输出内容  
     * @return type - 输出类型  
     */  
    public String ajax(String content, String type) {   
        try {   
            HttpServletResponse response = ServletActionContext.getResponse();   
            response.setContentType(type + ";charset=GBK");   
            response.setHeader("Pragma", "No-cache");   
            response.setHeader("Cache-Control", "no-cache");   
            response.setDateHeader("Expires", 0);   
            response.getWriter().write(content);   
            response.getWriter().flush();   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        return null;   
    }   
  
    /**  
     * AJAX输出文本，返回null  
     * @param test - 文本内容  
     * @return String - String  
     */  
    public String ajaxText(String text) {   
        return ajax(text, "text/plain");   
    }   
  
    /**  
     * AJAX输出HTML，返回null  
     * @param html - html内容  
     * @return String - String  
     */  
    public String ajaxHtml(String html) {   
        return ajax(html, "text/html");   
    }   
  
    /**  
     * AJAX输出XML，返回null  
     * @param xml - xml  
     * @return String - String  
     */  
    public String ajaxXml(String xml) {   
        return ajax(xml, "text/xml");   
    }   
  
    /**  
     * 根据字符串输出JSON，返回null  
     * @param jsonString - 字符串内容  
     * @return String - 处理过后的String  
     */  
    public String ajaxJson(String jsonString) {   
        return ajax(jsonString, "text/html");   
    }  
	
}
