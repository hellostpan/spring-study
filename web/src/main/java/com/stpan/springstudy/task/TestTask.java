package com.stpan.springstudy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 定时任务
 * author:  STPAN
 * time:    2018/4/11 21:19
 */
@Component
public class TestTask {

//    @Scheduled(fixedDelay = 3000)//每三秒一次
/*    @Scheduled(cron = "10-20 1-20 * * * ? ")//可以去http://cron.qqe2.com/生成想要的时间区间
    public void test(){
        System.out.println("hello world");
    }*/
}
