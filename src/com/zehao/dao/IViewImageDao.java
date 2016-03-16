package com.zehao.dao;

import java.util.List;

import com.zehao.model.ViewImage;

public interface IViewImageDao extends IBaseDao<ViewImage> {
	
	/**
	 * 获取图片URL列表
	 * @param sign 标志，0表示获取village，1表示获取view，2表示获取user
	 * @param id 条件Id
	 * @return
	 */
	public List<String> getVillageUrl(int sign, int id);

}
