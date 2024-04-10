package com.sp.spgovtechscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpGovtechSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpGovtechSchedulerApplication.class, args);
	}

}
