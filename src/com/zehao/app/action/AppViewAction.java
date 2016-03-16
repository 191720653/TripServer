package com.zehao.app.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Views;
import com.zehao.service.IViewImageService;
import com.zehao.service.IViewsService;
import com.zehao.util.Tool;
/**
 * < TODO：获取四大景区各个景点的详细信息，用户点击景点后，发送景点Id过来
 * 			1、此景点下还有做区分，则返回景点的区分列表
 * 			2、否则返回景点的详细信息 >
 * @ClassName: AppViewAction
 * @author pc-hao
 * @date 2016年3月14日 下午6:26:48
 * @version V 1.0
 */
public class AppViewAction extends AppBaseAction {
	
	private static final long serialVersionUID = -6458481643078754430L;
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
	private String viewId = null;
	private String viewSign = null;
	
	/**
	 * 获取景点信息
	 */
	public void getViewInfo(){
		
	}
	
	/**
	 * 获取景点信带息列表
	 */
	public void getViewList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				viewId = json.getString(CONSTANT.VIEW_ID);
				viewSign = json.getString(CONSTANT.VIEW_SIGN);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || CONSTANT.NULL_STRING.equals(Tool.NVL(viewId))
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(viewSign))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getViewList fail, order or viewId can't be null ----------");
				} else if (!CONSTANT.VIEW_LIST.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getViewList fail, order wrong ----------");
				} else {
					// 获取景点的图片列表
					List<String> list = iViewImageService.getVillageUrl(1, Integer.parseInt(viewId));
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					json.put(CONSTANT.VIEW_PICTURE, JSONArray.fromObject(list));
					
					if(CONSTANT.VIEW_SIGN_Y.equals(viewSign)){
						// 获取景点内子景点列表
						List<Views> viewList = iViewsService.findByProperty("upView", Integer.parseInt(viewId));
						for(int i=0;i<viewList.size();i++){
							viewList.get(i).setVillage(null);
							viewList.get(i).setCreateDate(null);
						}
						json.put(CONSTANT.VIEW_CHILD, JSONArray.fromObject(viewList));
						logger.info("---------- getViewList with child success, turn to index page ----------");
					}

					appJson(json.toString());
					logger.info("---------- getViewList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getViewList error: " + e.toString() + " ----------");
		}
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
