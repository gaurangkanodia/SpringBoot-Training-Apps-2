package com.ariba.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ariba.training.dal.ProductDAOInMemoryImpl;
import com.ariba.training.service.ProductService;
import com.ariba.training.service.ProductServiceImpl;
import com.ariba.training.ui.ProductConsoleUI;

@Configuration
public class MyBootTrainingAppConfig {

	/*@Bean
	public ProductDAOInMemoryImpl dao() {
		return new ProductDAOInMemoryImpl();
	}
	
	@Bean
	public ProductService service() {
		ProductServiceImpl service = new ProductServiceImpl();
		service.setProductDao(dao());
		return service;
	}
	
	@Bean
	public ProductConsoleUI ui()
	{
		ProductConsoleUI ui = new ProductConsoleUI();
		ui.setProductService(service());
		return ui;
	}*/

}
