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
	 * 登錄前請求地址
	 */
	public static final String TOWHERE = "towhere";
	
	/**
	 * 分页结果key
	 */
	public static final String PAGER = "pager";
	
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
	
	/**
	 * 管理员标志
	 */
	public static final int ROLE_SIGN_ADMIN = 1;
	/**
	 * 普通用户标志
	 */
	public static final int ROLE_SIGN_USER = 2;
	/**
	 * 账号锁定标志
	 */
	public static final int ACCOUNT_LOCK = 3;
	
	/**
	 * 表头数据key
	 */
	public static final String TITLE_LIST = "TitleList";
	/**
	 * 查询参数key
	 */
	public static final String PRAM = "pram";
	/**
	 * Village数组key
	 */
	public static final String VILLAGES = "villages";
	
	/****************************************************************
	    *********************** 通用变量  **************************
	 ****************************************************************/
	
	/**
	 * 错误代码 key: errcode
	 */
	public static final String ERRCODE = "errcode";
	/**
	 * 空字符串：value ""
	 */
	public static final String NULL_STRING = "";
	/**
	 * 有没有的标志 key: common_sign
	 */
	public static final String COMMON_SIGN = "common_sign";
	/**
	 * 有的标志 value: common_sign_has
	 */
	public static final String COMMON_SIGN_HAS = "common_sign_has";
	/**
	 * 没有的标志 value: common_sign_not
	 */
	public static final String COMMON_SIGN_NOT = "common_sign_not";
	
	
	/****************************************************************
	    *********************** 用户信息  **************************
	 ****************************************************************/
	
	/**
	 * 用户登录标志位 value：on
	 */
	public static final String LOGIN_SIGN_ON = "on";
	/**
	 * 用户登录标志位 value：off
	 */
	public static final String LOGIN_SIGN_OFF = "off";
	/**
	 * 用户类型 key：type
	 */
	public static final String USER_TYPE = "type";
	/**
	 * 用户类型 key：type_id
	 */
	public static final String USER_TYPE_ID = "type_id";
	/**
	 * 普通用户类型 value：common
	 */
	public static final String USER_TYPE_COMMON = "common";
	/**
	 * QQ用户类型 value：qq
	 */
	public static final String USER_TYPE_QQ = "QZone";
	/**
	 * SINA用户类型 value：sina
	 */
	public static final String USER_TYPE_SINA = "SinaWeibo";
	/**
	 * WECHAT用户类型 value：wechat
	 */
	public static final String USER_TYPE_WECHAT = "Wechat";
	/**
	 * 用户信息 key：userinfo
	 */
	public static final String USER_INFO = "user_info";
	/**
	 * 用户账号 key：account
	 */
	public static final String ACCOUNT = "account";
	/**
	 * 用户密码 key：password
	 */
	public static final String PASSWORD = "password";
	/**
	 * 用户头像 key：icon
	 */
	public static final String ICON = "icon";
	/**
	 * 用户昵称 key：nick_name
	 */
	public static final String NICK_NAME = "nick_name";
	/**
	 * 用户性别 key：sex
	 */
	public static final String SEX = "sex";
	/**
	 * 用户性别 value：男
	 */
	public static final String SEX_BOY = "男";
	/**
	 * 用户性别 value：女
	 */
	public static final String SEX_GIRL = "女";
	/**
	 * 用户性别 value：不详
	 */
	public static final String SEX_UNN = "不详";
	/**
	 * 用户备注 key：remark
	 */
	public static final String REMARK = "remark";
	/**
	 * 用户token key：token
	 */
	public static final String TOKEN = "token";
	
	/****************************************************************
	    *********************** 错误代码 **************************
	 ****************************************************************/
	
	/**
	 * 用户请求成功状态 value：168
	 */
	public static final String CODE_168 = "168";
	/**
	 * 用户请求成功状态 value：168 TEXT
	 */
	public static final String CODE_168_TEXT = "用户请求成功!";
	/**
	 * 用户请求的参数为空 value：171
	 */
	public static final String CODE_171 = "171";
	/**
	 * 用户请求的参数值为空 value：171 TEXT
	 */
	public static final String CODE_171_TEXT = "用户请求的参数值为空！";
	/**
	 * 用户登录账号密码为空 value：172
	 */
	public static final String CODE_172 = "172";
	/**
	 * 用户登录账号密码为空 value：172 TEXT
	 */
	public static final String CODE_172_TEXT = "用户登录账号密码为空！";
	/**
	 * 用户登录账号密码错误 value：173
	 */
	public static final String CODE_173 = "173";
	/**
	 * 用户登录账号密码错误 value：173 TEXT
	 */
	public static final String CODE_173_TEXT = "用户登录账号密码错误！";
	/**
	 * 用户请求的键值不对 value：174
	 */
	public static final String CODE_174 = "174";
	/**
	 * 用户请求的键值不对 value：174 TEXT
	 */
	public static final String CODE_174_TEXT = "用户请求的键值不正确！";
	/**
	 * 用户token不存在 value：175
	 */
	public static final String CODE_175 = "175";
	/**
	 * 用户token不存在 value：175 TEXT
	 */
	public static final String CODE_175_TEXT = "用户token不存在！";
	/**
	 * 用户账号已被使用 value：176
	 */
	public static final String CODE_176 = "176";
	/**
	 * 用户账号已被使用 value：176 TEXT
	 */
	public static final String CODE_176_TEXT = "此账号已被使用！";
	/**
	 * 用户账号已被冻结 value：177
	 */
	public static final String CODE_177 = "177";
	/**
	 * 用户账号已被冻结 value：177 TEXT
	 */
	public static final String CODE_177_TEXT = "账号已被冻结！";
	
}
