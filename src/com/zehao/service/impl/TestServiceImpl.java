package com.zehao.service.impl;

import com.zehao.dao.ITestDao;
import com.zehao.model.Test;
import com.zehao.service.ITestService;

public class TestServiceImpl extends BaseServiceImpl<Test> implements ITestService {

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ((ITestDao)getIBaseDao()).size();
	}

}
