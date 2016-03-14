package com.zehao.dao;

import java.util.List;

import com.zehao.model.ViewImage;

public interface IViewImageDao extends IBaseDao<ViewImage> {
	
	public List<String> getVillageUrl(int sign, int id);

}
