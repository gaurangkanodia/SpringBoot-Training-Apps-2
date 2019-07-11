package com.ariba.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ariba.training.ui.ProductConsoleUI;

@SpringBootApplication
public class TrainingBootAppApplication {

	
	/*
	 * Always get Bean by dependency injection, never do new on a bean. 
	 * Otherwise SpringBoot will not manage that objects lifecycle.
	 */
	
	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(TrainingBootAppApplication.class, args);
		ProductConsoleUI ui = (ProductConsoleUI) container.getBean("ui");
		ui.createProductWithUI();
	}
}
