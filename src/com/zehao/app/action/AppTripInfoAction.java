package com.zehao.app.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.TripInfo;
import com.zehao.service.ITripInfoService;
import com.zehao.util.Tool;
/**
 * < TODO：获取旅游信息 >
 * @ClassName: AppTripInfoAction
 * @author pc-hao
 * @date 2016年3月14日 下午6:26:48
 * @version V 1.0
 */
public class AppTripInfoAction extends AppBaseAction {
	
	private static final long serialVersionUID = -6458481643078754430L;
	private ITripInfoService iTripInfoService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private int type = -1;
	
	public void getTripInfoList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				type = json.getInt(CONSTANT.TRIP_TYPE_ID);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || type == -1) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getTripInfoList fail, order can't be null ----------");
				} else if (!CONSTANT.TRIP_INFO_ORDER.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getTripInfoList fail, order wrong ----------");
				} else {
					// 获取旅游信息的列表
					List<TripInfo> list = iTripInfoService.findByProperty("typeId", type);
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					json.put(CONSTANT.TRIP_INFO_DATA, JSONArray.fromObject(list));
					appJson(json.toString());
					logger.info("---------- getTripInfoList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getTripInfoList error: " + e.toString() + " ----------");
		}
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public ITripInfoService getiTripInfoService() {
		return iTripInfoService;
	}

	public void setiTripInfoService(ITripInfoService iTripInfoService) {
		this.iTripInfoService = iTripInfoService;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
