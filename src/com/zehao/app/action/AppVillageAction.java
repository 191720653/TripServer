package com.zehao.app.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Views;
import com.zehao.model.Village;
import com.zehao.service.IViewImageService;
import com.zehao.service.IViewsService;
import com.zehao.service.IVillageService;
import com.zehao.util.Tool;
/**
 * < TODO：获取四大景区列表 >
 * @ClassName: VillageAction
 * @author pc-hao
 * @date 2016年3月11日 下午6:26:48
 * @version V 1.0
 */
public class AppVillageAction extends AppBaseAction {

	private static final long serialVersionUID = -7749299223425979759L;
	private IVillageService iVillageService;
	private IViewImageService iViewImageService;
	private IViewsService iViewsService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private String mainId = null;
	
	/**
	 * 获取四大地区信息列表
	 */
	public void getMainList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				mainId = json.getString(CONSTANT.MAIN_VIEW_ID);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || CONSTANT.NULL_STRING.equals(Tool.NVL(mainId))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getMainList fail, order or mainId can't be null ----------");
				} else if (!CONSTANT.MAIN_VIEW.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getMainList fail, order wrong ----------");
				} else {
					// 获取景区的图片列表
					List<String> list = iViewImageService.getUrl(0, Integer.parseInt(mainId));
					// 获取景区的信息
					Village village = iVillageService.findById(Integer.parseInt(mainId));
					village.setCreateDate(null);
					// 获取景区内景点列表
					String sql = "From Views vs Where vs.village.villageId=? And vs.upView is null";
					List<Object> value = new ArrayList<Object>();value.add(Integer.parseInt(mainId));
					List<Views> viewList = iViewsService.findByHQL(sql, value);
					for(int i=0;i<viewList.size();i++){
						viewList.get(i).setVillage(null);
						viewList.get(i).setCreateDate(null);
					}
					
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					json.put(CONSTANT.MAIN_VIEW_PICTURE, JSONArray.fromObject(list));
					json.put(CONSTANT.MAIN_VIEW_INFO, JSONObject.fromObject(village));
					json.put(CONSTANT.MAIN_VIEW_CHILDVIEW, JSONArray.fromObject(viewList));
					appJson(json.toString());
					logger.info("---------- getMainList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getMainList error: " + e.toString() + " ----------");
		}
	}

	public IVillageService getiVillageService() {
		return iVillageService;
	}

	public void setiVillageService(IVillageService iVillageService) {
		this.iVillageService = iVillageService;
	}

	public IViewImageService getiViewImageService() {
		return iViewImageService;
	}

	public void setiViewImageService(IViewImageService iViewImageService) {
		this.iViewImageService = iViewImageService;
	}

	public IViewsService getiViewsService() {
		return iViewsService;
	}

	public void setiViewsService(IViewsService iViewsService) {
		this.iViewsService = iViewsService;
	}

}
