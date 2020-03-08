package com.estrok.estrokApp.job;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.estrok.estrokApp.service.DailyStockHistoryService;

public class DailyStockHistoryJob extends QuartzJobBean implements InterruptableJob{

	@Autowired
	DailyStockHistoryService service;
	
	@Override
	public void interrupt() throws UnableToInterruptJobException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		try {
			service.insertGetHistoricData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
