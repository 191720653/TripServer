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
	/**
	 * View数组key
	 */
	public static final String VIEWS = "views";
	
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
	/**
	 * 获取数据 key: get_data
	 */
	public static final String APP_GET_DATA = "get_data";
	
	/****************************************************************
	    *********************** 用户反馈  **************************
	 ****************************************************************/
	
	/**
	 * 反馈的命令 value: user_suggest
	 */
	public static final String USER_SUGGEST = "user_suggest";
	/**
	 * 反馈的内容 key: user_suggest_content
	 */
	public static final String USER_SUGGEST_CONTENT = "user_suggest_content";
	
	/****************************************************************
	    *********************** 分类变量  **************************
	 ****************************************************************/
	
	/**
	 * 分类的命令 value: sort_view
	 */
	public static final String SORT_VIEW = "sort_view";
	/**
	 * 分类的列表 value: sort_view_list
	 */
	public static final String SORT_VIEW_LIST = "sort_view_list";
	/**
	 * 分类的类型 value: sort_view_type
	 */
	public static final String SORT_VIEW_TYPE = "sort_view_type";
	/**
	 * 分类的类型经典古建 value: sort_view_type_build
	 */
	public static final String SORT_VIEW_TYPE_BUILD = "经典古建";
	/**
	 * 分类的类型名木古树 value: sort_view_type_tree
	 */
	public static final String SORT_VIEW_TYPE_TREE = "名木古树";
	/**
	 * 分类的类型名人典故 value: sort_view_type_person
	 */
	public static final String SORT_VIEW_TYPE_PERSON = "名人典故";
	/**
	 * 分类的类型民品民俗 value: sort_view_type_custom
	 */
	public static final String SORT_VIEW_TYPE_CUSTOM = "民品民俗";
	
	/****************************************************************
	    *********************** 点赞变量  **************************
	 ****************************************************************/
	
	/**
	 * 点赞的命令 value: like_add
	 */
	public static final String LIKE_ADD = "like_add";
	/**
	 * 点赞的Id key: like_id
	 */
	public static final String LIKE_ID = "like_id";
	/**
	 * 点赞的类型 key: like_type
	 */
	public static final String LIKE_TYPE = "like_type";
	/**
	 * 点赞的类型1 value: like_type_view
	 */
	public static final String LIKE_TYPE_VIEW = "like_type_view";
	/**
	 * 点赞的类型2 value: like_type_village
	 */
	public static final String LIKE_TYPE_VILLAGE = "like_type_village";
	/**
	 * 点赞的时间戳 key: like_sign
	 */
	public static final String LIKE_SIGN = "like_sign";
	/**
	 * 点赞后的数量 key: like_num
	 */
	public static final String LIKE_NUM = "like_num";
	
	/****************************************************************
	    *********************** 景点信息  **************************
	 ****************************************************************/
	
	/**
	 * 获取景点信息带列表 value：view_ist
	 */
	public static final String VIEW_LIST = "view_list";
	/**
	 * 获取的景点的Id key：view_id
	 */
	public static final String VIEW_ID = "view_id";
	/**
	 * 获取的景点是否有子景点 key：view_sign
	 */
	public static final String VIEW_SIGN = "view_sign";
	/**
	 * 获取的景点有子景点 value：view_sign_y
	 */
	public static final String VIEW_SIGN_Y = "Y";
	/**
	 * 获取的景点没有子景点 value：view_sign_n
	 */
	public static final String VIEW_SIGN_N = "N";
	/**
	 * 获取的景点的图片列表 key：view_picture
	 */
	public static final String VIEW_PICTURE = "view_picture";
	/**
	 * 获取的景点的子区列表 key：view_child
	 */
	public static final String VIEW_CHILD = "view_child";
	
	/****************************************************************
	    *********************** 四大景区  **************************
	 ****************************************************************/
	
	/**
	 * 获取四大景区列表 value：main_view
	 */
	public static final String MAIN_VIEW = "main_view";
	/**
	 * 获取四大景区Id key：main_view_id
	 */
	public static final String MAIN_VIEW_ID = "main_view_id";
	/**
	 * 获取四大景区信息 key：main_view_info
	 */
	public static final String MAIN_VIEW_INFO = "main_view_info";
	/**
	 * 获取四大景区图片列表 key：main_view_picture
	 */
	public static final String MAIN_VIEW_PICTURE = "main_view_picture";
	/**
	 * 获取四大景区景点列表 key：main_view_childview
	 */
	public static final String MAIN_VIEW_CHILDVIEW = "main_view_childview";
	
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
	/**
	 * 用户相册 key：pictures
	 */
	public static final String PICTURES = "pictures";
	/**
	 * 用户相册数量 key：picture_count
	 */
	public static final String PICTURE_COUNT = "picture_count";
	
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
	/**
	 * 获取数据的口令不对 value：178
	 */
	public static final String CODE_178 = "178";
	/**
	 * 获取数据的口令不对 value：178 TEXT
	 */
	public static final String CODE_178_TEXT = "获取数据的口令不对！";
	
}
