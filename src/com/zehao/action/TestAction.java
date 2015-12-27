package com.zehao.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zehao.model.Test;
import com.zehao.service.ITestService;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ITestService iTestService;

	public void setITestService(ITestService iTestService) {
		this.iTestService = iTestService;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		 System.out.println("The size of Table Role is " +
		 iTestService.size());

		// 测试插入
		Test test = new Test();
		System.out.println("-------------------- add start ------------------------");
		test.setContent("This is a sample test!");
		System.out.println("For testing: add " + test.toString());
		int id = (Integer) iTestService.save(test);
		System.out.println("Add success, the id is " + id);
		System.out.println("The size of table: " + iTestService.getSize());
		System.out.println("-------------------- add end ------------------------");

		// 测试更新
		System.out.println("-------------------- 更新开始 ------------------------");
		Test temp = iTestService.findById(id);
		temp.setContent("Here for testing update method!");
		iTestService.update(temp);
		temp = iTestService.findById(id);
		System.out.println("Update result: " + temp.toString());
		System.out.println("-------------------- 更新结束 ------------------------");

		// 测试删除
		System.out.println("-------------------- 删除开始 ------------------------");
		iTestService.delete(id);
		System.out.println("The size of table: " + iTestService.getSize());
		System.out.println("-------------------- 删除结束 ------------------------");

		return SUCCESS;
	}

}
