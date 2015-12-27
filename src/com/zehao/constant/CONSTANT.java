package com.zehao.constant;

public class CONSTANT {
	
	/**
	 * session中存放是否登录的标志，以此key获取userAccount
	 */
	public static final String LOGIN_SIGN = "LOGIN_SIGN";
	
	/**
	 * session中存放用户角色的标志，以此key获取userRoles
	 */
	public static final String ROLE_SIGN = "ROLE_SIGN";
	
	/**
	 * session中存放用户访问站点域名的标志，以此key获取domain
	 */
	public static final String DOMAIN_SIGN = "DOMAIN_SIGN";
	
	/**
	 * session中存用户管理权限的标志，以此key获取管理功能的url
	 */
	public static final String ROLE_URL = "url";
	
	/**
	 * 登录错误信息提示，返回logerr.jsp页面
	 */
	public static final String LOGERR = "logerr";
	
	/**
	 * 登錄錯誤信息
	 */
	public static final String ERRMSG = "errmsg";
	
	/**
	 * 登錄錯誤代码
	 */
	public static final String ERRCODE = "errcode";
	
	/**
	 * 登錄前請求地址
	 */
	public static final String TOWHERE = "towhere";
	
	/**
	 * 分页大小
	 */
	public static final int PAGE_SIZE = 10;
	
	/**
	 * Action返回结果，重定向
	 */
	public static final String REDIRECT = "redirect";
	
	/**
	 * 保存更新操作日志
	 */
	public static final String LOG_UPDATE = "Update：";
	
	/**
	 * 保存删除操作日志
	 */
	public static final String LOG_DELETE = "Delete：";
	
	/**
	 * 保存增加操作日志
	 */
	public static final String LOG_SAVE = "Save：";

	/**
	 * 保存查询操作日志
	 */
	public static final String LOG_FIND = "Find：";
	
	/**
	 * 保存登录操作日志
	 */
	public static final String LOG_LOGIN = "Login：";
	
	/**
	 * 保存注销操作日志
	 */
	public static final String LOG_LOGOUT = "Logout：";
	
	/**
	 * 分隔符 || 
	 */
	public static final String BREAK_CHAR = " || ";
	
	/**
	 * request
	 */
	public static final String REQUEST = "request";
	
	/**
	 * message
	 */
	public static final String MESSAGE = "message";
	
	/**
	 * download
	 */
	public static final String DOWNLOAD = "download";
	
	/**
	 * salesman
	 */
	public static final String SALESMAN = "salesman";
	
}
