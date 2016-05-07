package com.zehao.app.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.TripType;
import com.zehao.service.ITripTypeService;
import com.zehao.util.Tool;
/**
 * < TODO：获取旅游类型 >
 * @ClassName: AppTripTypeAction
 * @author pc-hao
 * @date 2016年3月14日 下午6:26:48
 * @version V 1.0
 */
public class AppTripTypeAction extends AppBaseAction {
	
	private static final long serialVersionUID = -6458481643078754430L;
	private ITripTypeService iTripTypeService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	
	public void getTripTypeList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getTripTypeList fail, order can't be null ----------");
				} else if (!CONSTANT.TRIP_TYPE_ORDER.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getTripTypeList fail, order wrong ----------");
				} else {
					// 获取旅游类型的列表
					List<TripType> list = iTripTypeService.getAll();
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					json.put(CONSTANT.TRIP_TYPE_DATA, JSONArray.fromObject(list));
					appJson(json.toString());
					logger.info("---------- getTripTypeList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getTripTypeList error: " + e.toString() + " ----------");
		}
	}

	public ITripTypeService getiTripTypeService() {
		return iTripTypeService;
	}

	public void setiTripTypeService(ITripTypeService iTripTypeService) {
		this.iTripTypeService = iTripTypeService;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
