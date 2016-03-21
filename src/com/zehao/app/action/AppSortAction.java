package com.zehao.app.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Views;
import com.zehao.service.IViewsService;
import com.zehao.util.Tool;
/**
 * < TODO：获取不同的分类列表 >
 * @ClassName: AppSortAction
 * @author pc-hao
 * @date 2016年3月14日 下午6:26:48
 * @version V 1.0
 */
public class AppSortAction extends AppBaseAction {
	
	private static final long serialVersionUID = -6458481643078754430L;
	private IViewsService iViewsService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private String sortType = null;
	
	/**
	 * 获取景点分类列表
	 */
	public void getSortList() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				sortType = json.getString(CONSTANT.SORT_VIEW_TYPE);

				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) 
						|| CONSTANT.NULL_STRING.equals(Tool.NVL(sortType))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- getSortList fail, order or sortType can't be null ----------");
				} else if (!CONSTANT.SORT_VIEW.equals(order)){
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- getSortList fail, order wrong ----------");
				} else {
					json = new JSONObject();
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
					// 获取景点列表
					List<Views> viewList = iViewsService.findByProperty("remark", sortType);
					if(viewList.size()>0){
						for(int i=0;i<viewList.size();i++){
							viewList.get(i).setVillage(null);
							viewList.get(i).setCreateDate(null);
						}
						json.put(CONSTANT.SORT_VIEW_LIST, viewList);
						json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_HAS);
					}else{
						json.put(CONSTANT.COMMON_SIGN, CONSTANT.COMMON_SIGN_NOT);
					}

					appJson(json.toString());
					logger.info("---------- getSortList success, turn to index page ----------");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- getSortList error: " + e.toString() + " ----------");
		}
	}

	public IViewsService getiViewsService() {
		return iViewsService;
	}

	public void setiViewsService(IViewsService iViewsService) {
		this.iViewsService = iViewsService;
	}

}
