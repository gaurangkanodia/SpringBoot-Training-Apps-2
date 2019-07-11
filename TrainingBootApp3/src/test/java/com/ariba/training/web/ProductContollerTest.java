package com.ariba.training.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.ariba.training.domain.Product;
import com.ariba.training.service.ProductService;


/*
 * This is in-container testing.
 * Spring Framework, Aspects, etc are included in this Test.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductContollerTest {

	public ProductContollerTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	MockMvc mvc; //We are testing a controller which gets called from an Http Request. This will help us mock that request.
	
	@MockBean
	ProductService service;
	
	@Test
	
	public void testGetById() throws Exception
	{
		//Arrange
		Product data = new Product("Test",1000,2000);
		data.setId(1);
		Mockito.when(service.findById(1)).thenReturn(data);
		
		//Act and Assert
		ResultActions a = mvc.perform(get("/products/{id}", 1).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)));
	}

}
