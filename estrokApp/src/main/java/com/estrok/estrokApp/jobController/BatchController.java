package com.estrok.estrokApp.jobController;

import static org.quartz.JobBuilder.newJob;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.estrok.estrokApp.job.DailyEachStockHistoryJob;
import com.estrok.estrokApp.job.DailyStockHistoryJob;

@Controller
@SuppressWarnings("rawtypes")
public class BatchController {

	@Autowired
	private Scheduler scheduler;
	
	@PostConstruct
	public void start() {
		
		try {
//		JobDetail getEachStockDataJobDetail = buildJobDetail(GetEachStockDataJob.class, "getEachStockData", "stock", new HashMap());
//		JobDetail getHistoricStockDataJobDetail = buildJobDetail(GetEachStockDataJob.class, "getEachStockData", "stock", new HashMap());
			JobDetail dailyStockHistoryJob = buildJobDetail(DailyStockHistoryJob.class, "DailyStockHistoryJob", "stock", new HashMap());
			JobDetail dailyEachStockHistoryJob = buildJobDetail(DailyEachStockHistoryJob.class, "DailyEachStockHistoryJob", "stock", new HashMap());
			
			scheduler.scheduleJob(dailyStockHistoryJob, buildJobTrigger("0 40 22 * * ?"));
			scheduler.scheduleJob(dailyEachStockHistoryJob, buildJobTrigger("0 00 23 * * ?"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//String scheduleExp = "0 * * * * ?"; 초 분 시 일 월 ?
	public Trigger buildJobTrigger(String scheduleExp) {
		return TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp)).build();
	}
	
	@SuppressWarnings("unchecked")
	public JobDetail buildJobDetail(Class job, String name, String group, Map params) {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.putAll(params);
		return newJob(job).withIdentity(name, group).usingJobData(jobDataMap).build();
		
	}
	
}
