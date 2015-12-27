package com.zehao.dao.impl;

import com.zehao.dao.ITestDao;
import com.zehao.model.Test;

public class TestDaoImpl extends BaseDaoImpl<Test> implements ITestDao {

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return getSession().createSQLQuery("select * from roles").list()
				.size();
	}

}
