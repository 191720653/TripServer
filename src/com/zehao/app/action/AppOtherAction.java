package com.zehao.app.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Other;
import com.zehao.service.IOtherService;
import com.zehao.util.Tool;
/**
 * < TODO：获取其它信息 >
 * @ClassName: AppOtherAction
 * @author pc-hao
 * @date 2016年3月14日 下午6:26:48
 * @version V 1.0
 */
public class AppOtherAction extends AppBaseAction {
	
	private static final long serialVersionUID = -6458481643078754430L;
	private IOtherService iOtherService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private String type = "";
	
	public void getOtherInfoList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				type = json.getString(CONSTANT.OTHER_TYPE);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || CONSTANT.NULL_STRING.equals(type)) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getOtherInfoList fail, order can't be null ----------");
				} else if (!CONSTANT.OTHER_INFO.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getOtherInfoList fail, order wrong ----------");
				} else {
					// 获取信息的列表
					List<Other> list = iOtherService.findByProperty("type", type);
					for(int i=0;i<list.size();i++){
						list.get(i).setCreateData(null);
					}
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					json.put(CONSTANT.OTHER_LIST, JSONArray.fromObject(list));
					appJson(json.toString());
					logger.info("---------- getOtherInfoList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getOtherInfoList error: " + e.toString() + " ----------");
		}
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public IOtherService getiOtherService() {
		return iOtherService;
	}

	public void setiOtherService(IOtherService iOtherService) {
		this.iOtherService = iOtherService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
