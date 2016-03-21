package com.zehao.app.action;

import java.util.Date;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Suggest;
import com.zehao.model.Users;
import com.zehao.service.ISuggestService;
import com.zehao.service.IUserService;
import com.zehao.util.Tool;
/**
 * < TODO：手机反馈接口 >
 * @ClassName: AppSuggestAction
 * @author pc-hao
 * @date 2016年3月11日 下午6:26:48
 * @version V 1.0
 */
public class AppSuggestAction extends AppBaseAction {
	
	private static final long serialVersionUID = -8338966371567146015L;
	private ISuggestService iSuggestService;
	private IUserService iUserService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private String token = null;
	private String content = null;
	
	/**
	 * 用户反馈
	 */
	public void suggest() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				token = json.getString(CONSTANT.TOKEN);
				content = json.getString(CONSTANT.USER_SUGGEST_CONTENT);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || CONSTANT.NULL_STRING.equals(Tool.NVL(token))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- suggest fail, order or token can't be null ----------");
				} else if (!CONSTANT.USER_SUGGEST.equals(order)) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- suggest fail, order wrong ----------");
				} else {
					Users user = iUserService.findUniqueByProperty(CONSTANT.TOKEN, token);
					if (user != null) {
						Suggest suggest = new Suggest();
						suggest.setSuggestContent(content);
						suggest.setUserId(user.getUserId());
						suggest.setCreateDate(new Date());
						iSuggestService.save(suggest);
						
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
						appJson(json.toString());
						logger.info("---------- suggest success, turn to index page ----------");
					} else {
						json = new JSONObject();
						json.put(CONSTANT.ERRCODE, CONSTANT.CODE_175);
						json.put(CONSTANT.MESSAGE, CONSTANT.CODE_175_TEXT);
						appJson(json.toString());
						logger.info("---------- suggest success, turn to index page ----------");
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- suggest error: " + e.toString() + " ----------");
		}
	}

	public ISuggestService getiSuggestService() {
		return iSuggestService;
	}

	public void setiSuggestService(ISuggestService iSuggestService) {
		this.iSuggestService = iSuggestService;
	}

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

}
