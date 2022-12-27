package com.exchangerater.webscraper.scheduler;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class WebScraperScheduler {

    @Schedule()
    public void scheduleWebScraper() {
        //TODO akos 2022.12.27
    }
}
