package com.zehao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SiteListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		// 获取项目路径
		arg0.getServletContext().getRealPath("/");
		
		// 需要做的任务
		System.out.println("---------- 监听器启动 ----------");
	}

}
