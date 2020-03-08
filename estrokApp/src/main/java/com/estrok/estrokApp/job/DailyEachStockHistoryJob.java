package com.estrok.estrokApp.job;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.estrok.estrokApp.service.DailyEachStockHistoryService;

public class DailyEachStockHistoryJob extends QuartzJobBean implements InterruptableJob{

	@Autowired
	DailyEachStockHistoryService service;
	
	@Override
	public void interrupt() throws UnableToInterruptJobException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		try {
			service.insertDailyEachStockHistoryData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
