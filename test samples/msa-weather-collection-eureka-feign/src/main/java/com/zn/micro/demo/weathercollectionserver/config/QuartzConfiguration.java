/**
 * 
 */
package com.zn.micro.demo.weathercollectionserver.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zn.micro.demo.weathercollectionserver.job.WeatherDataSyncJob;

/**
 * @author zhengnan
 *
 */
@Configuration
public class QuartzConfiguration {
	@Bean
	public JobDetail weatherDataSyncJob() {
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
	}
	
	@Bean
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule();
		builder.withIntervalInSeconds(60).repeatForever();
		
		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJob()).withIdentity("weatherDataSyncTrigger").withSchedule(builder).build();
	}
}
