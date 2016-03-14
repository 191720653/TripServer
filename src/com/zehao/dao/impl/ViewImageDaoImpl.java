package com.zehao.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.zehao.dao.IViewImageDao;
import com.zehao.model.ViewImage;

public class ViewImageDaoImpl extends BaseDaoImpl<ViewImage> implements IViewImageDao {

	@Override
	public List<String> getVillageUrl(int sign, int id) {
		// TODO Auto-generated method stub
		String sql = null;
		if(sign==0){
			sql = "select image_url from view_image where village_id=?";
		}else if(sign==1){
			sql = "select image_url from view_image where view_id=?";
		}else{
			sql = "select image_url from view_image where user_id=?";
		}
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, id);
		@SuppressWarnings("unchecked")
		List<String> list = query.list();
		return list;
	}

}
