package com.zehao.service.impl;

import java.util.List;

import com.zehao.dao.IViewImageDao;
import com.zehao.model.ViewImage;
import com.zehao.service.IViewImageService;

public class ViewImageServiceImpl extends BaseServiceImpl<ViewImage> implements IViewImageService {

	@Override
	public List<String> getUrl(int sign, int id) {
		// TODO Auto-generated method stub
		return ((IViewImageDao)getIBaseDao()).getUrl(sign, id);
	}

}
