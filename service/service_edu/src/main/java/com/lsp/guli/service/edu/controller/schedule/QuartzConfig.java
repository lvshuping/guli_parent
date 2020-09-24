package com.lsp.guli.service.edu.controller.schedule;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import javax.annotation.Resource;

@Configuration
public class QuartzConfig {


    @Resource
    private ScheduleTask scheduleTask;

    /**
     * 配置定时任务1
     * @return
     */
    @Bean(name="firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(){
        MethodInvokingJobDetailFactoryBean method = new MethodInvokingJobDetailFactoryBean();
        // 为需要执行的实体类对应的对象
        method.setTargetObject(scheduleTask);
        // 需要执行的方法
        method.setTargetMethod("test");
        // 是否并发执行
        method.setConcurrent(false);
        return method;
    }


    /**
     *   配置触发器1
     *   @param firstJobDetail
     *   @return
     */
    @Bean(name="firstTrigger")
    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail){
        SimpleTriggerFactoryBean simpleBean = new SimpleTriggerFactoryBean();
        simpleBean.setJobDetail(firstJobDetail);
        // 设置任务启动延迟
        simpleBean.setStartDelay(1000);
        // 每1秒执行一次
        simpleBean.setRepeatInterval(5000);
        //设置重复计数
        //simpleBean.setRepeatCount(0);
        return simpleBean;
    }

    /**
     *  配置Scheduler
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger firstTrigger){
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setTriggers(firstTrigger);
        return factoryBean;
    }



}
