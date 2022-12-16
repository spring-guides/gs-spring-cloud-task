package com.example.task;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return new HelloWorldApplicationRunner();
	}

	@BeforeTask
	public void beforeMethod(TaskExecution taskExecution) {
		System.out.println("Before task");
	}

	@AfterTask
	public void afterMethod(TaskExecution taskExecution) {
		System.out.println("After task");
	}

	public static class HelloWorldApplicationRunner implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println("Hello Spring Cloud Task!");
		}
	}
}
