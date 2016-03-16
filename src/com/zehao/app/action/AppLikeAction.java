package com.zehao.app.action;

import net.sf.json.JSONObject;

import com.zehao.constant.CONSTANT;
import com.zehao.model.Views;
import com.zehao.model.Village;
import com.zehao.service.IViewsService;
import com.zehao.service.IVillageService;
import com.zehao.util.Tool;
/**
 * < TODO：手机点赞接口 >
 * @ClassName: AppLikeAction
 * @author pc-hao
 * @date 2016年3月11日 下午6:26:48
 * @version V 1.0
 */
public class AppLikeAction extends AppBaseAction {
	
	private static final long serialVersionUID = -8338966371567146015L;
	private IVillageService iVillageService;
	private IViewsService iViewsService;
	
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	private String order = null;
	private String likeId = null;
	private String likeType = null;
	private Long likeSign = null;
	
	/**
	 * 获取四大地区信息列表
	 */
	public void addLike() {
		try {
			json = getDataJson(data);
			if (json == null) {
				nullData();
			} else {

				order = json.getString(CONSTANT.APP_GET_DATA);
				likeId = json.getString(CONSTANT.LIKE_ID);
				likeType = json.getString(CONSTANT.LIKE_TYPE);
				likeSign = json.getLong(CONSTANT.LIKE_SIGN);
				// 非空校验
				if (CONSTANT.NULL_STRING.equals(Tool.NVL(order)) || CONSTANT.NULL_STRING.equals(Tool.NVL(likeId))
						 || CONSTANT.NULL_STRING.equals(Tool.NVL(likeType)) || CONSTANT.NULL_STRING.equals(Tool.NVL(likeSign+CONSTANT.NULL_STRING))) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_171_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_171);
					appJson(json.toString());
					logger.info("---------- addLike fail, order or likeType or likeId or likeSign can't be null ----------");
				} else if (!CONSTANT.LIKE_ADD.equals(order)) {
					json = new JSONObject();
					json.put(CONSTANT.MESSAGE, CONSTANT.CODE_178_TEXT);
					json.put(CONSTANT.ERRCODE, CONSTANT.CODE_178);
					appJson(json.toString());
					logger.info("---------- addLike fail, order wrong ----------");
				} else if ((likeSign-System.currentTimeMillis())>12*60*60*1000) {
					error();
				} else {
					if (CONSTANT.LIKE_TYPE_VIEW.equals(likeType)) {
						Views view = iViewsService.findById(Integer.parseInt(likeId));
						if(view==null){
							error();
						}else {
							view.setLikeNum((view.getLikeNum()==null?0:view.getLikeNum()) + 1);
							iViewsService.update(view);

							json = new JSONObject();
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							json.put(CONSTANT.LIKE_NUM, view.getLikeNum());
							json.put(CONSTANT.LIKE_SIGN, System.currentTimeMillis());
							appJson(json.toString());
							logger.info("---------- addLike view success, turn to index page ----------");
						}
					} else if (CONSTANT.LIKE_TYPE_VILLAGE.equals(likeType)) {System.out.println(iVillageService==null);
						Village village = iVillageService.findById(Integer.parseInt(likeId));
						if(village==null){
							error();
						}else {
							village.setLikeNum((village.getLikeNum()==null?0:village.getLikeNum()) + 1);
							iVillageService.update(village);
							
							json = new JSONObject();
							json.put(CONSTANT.ERRCODE, CONSTANT.CODE_168);
							json.put(CONSTANT.LIKE_NUM, village.getLikeNum());
							json.put(CONSTANT.LIKE_SIGN, System.currentTimeMillis());
							appJson(json.toString());
							logger.info("---------- addLike village success, turn to index page ----------");
						}
					} else {
						error();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			errorData();
			logger.info("---------- addLike error: " + e.toString() + " ----------");
		}
	}
	
	public void error(){
		json = new JSONObject();
		json.put(CONSTANT.ERRCODE, CONSTANT.CODE_174);
		json.put(CONSTANT.MESSAGE, CONSTANT.CODE_174_TEXT);
		appJson(json.toString());
		logger.info("---------- addLike fail, likeType or likeId is worng ----------");
	}

	public IVillageService getiVillageService() {
		return iVillageService;
	}

	public void setiVillageService(IVillageService iVillageService) {
		this.iVillageService = iVillageService;
	}

	public IViewsService getiViewsService() {
		return iViewsService;
	}

	public void setiViewsService(IViewsService iViewsService) {
		this.iViewsService = iViewsService;
	}

}
