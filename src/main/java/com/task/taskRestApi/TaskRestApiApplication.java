package com.task.taskRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.task.taskRestApi")
public class TaskRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskRestApiApplication.class, args);
	}

}
