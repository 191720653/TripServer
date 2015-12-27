package com.zehao.timetask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.ContextLoader;

public class TimeTask extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub

		System.out.println("---------- 定时器执行定时调度任务 ----------");

		ApplicationContext context = ContextLoader
				.getCurrentWebApplicationContext();
		context.getBean("TestService");

		// 获取service开始任务

		System.out.println("---------- 定时任务调度执行结束 ----------");

	}

}
