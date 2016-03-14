package com.zehao.service;

import java.util.List;

import com.zehao.model.ViewImage;

public interface IViewImageService extends IBaseService<ViewImage> {
	
	public List<String> getVillageUrl(int sign, int id);

}
