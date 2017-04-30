package com.xeonwell.JerseyDemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xeowell on 2017/4/30.
 * scheduled task
 */
@Component
public class OutprintSchedule {
    /**
     * task run every 5 second
     */
    @Scheduled(cron = "0/60 * *  * * ? ")
    public void out() {
        System.out.println("jkjkjkjkkjkj");
    }

}
