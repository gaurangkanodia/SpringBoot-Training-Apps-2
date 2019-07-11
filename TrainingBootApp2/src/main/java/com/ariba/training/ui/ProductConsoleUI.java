package com.ariba.training.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ariba.training.domain.Product;
import com.ariba.training.service.ProductService;

@Component("ui")
public class ProductConsoleUI 
{
	@Autowired
	ProductService productService;
	
	public void createProductWithUI()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		System.out.println("Enter Price: ");
		int price = scan.nextInt();
		System.out.println("Enter Quantity on hand: ");
		int qoh = scan.nextInt();
		
		Product p = new Product(name, price, qoh);
		
		int saved = productService.createNewProduct(p);
		if(saved>=1)
		{
			System.out.println("New product saved successfully");
		}
		else
			System.out.println("Product save failed");
		
		
	}
/*
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	*/

	
	
}
