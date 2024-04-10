package com.sp.spgovtechscheduler;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.TimeZone;

@Slf4j
@Component
public class MyCustomScheduler {

    @Value("${custom.task.cron.expression}")
    private String customCronExp;

    @Value("${custom.task.cron.zone}")
    private String customCronZone;

    private CronTrigger cronTrigger;

    @PostConstruct
    public void beforeExecution() {
        /**
         * Run the below given line to see different timezones.
         * Here we can use these values in the dropdown to dynamically change the timezone from UI. ;-P
         * ZoneId.getAvailableZoneIds().forEach(log::info);
         * */
        this.cronTrigger = new CronTrigger(customCronExp, TimeZone.getTimeZone(customCronZone));
    }

    @Scheduled(cron = "${custom.task.cron.expression}", zone = "${custom.task.cron.zone}")
    public void scheduledTask() {
        log.info("Hello world!!");
        nextExecutionLog();
    }

    private void nextExecutionLog() {
        TriggerContext context = new SimpleTriggerContext();
        Instant instant = cronTrigger.nextExecution(context);
        Objects.requireNonNull(instant, "Instant shouldn't be null");
        log.info("Next execution: {}", ZonedDateTime.ofInstant(instant, ZoneId.of(customCronZone)));
    }

}
