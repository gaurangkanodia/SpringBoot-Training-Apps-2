package com.ariba.training.web;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ariba.training.TrainingBootAppApplication;
import com.ariba.training.dal.ProductDAO;
import com.ariba.training.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment=SpringBootTest.WebEnvironment.MOCK,
  classes = TrainingBootAppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-test.properties")

public class ProductControllerIntegrtionTest {

	@Autowired
	MockMvc mvc;
	
	@Qualifier("productDAOJPAImpl")
	@Autowired
	ProductDAO dao;
	
	@Test
	public void testGetById() throws Exception {
		//Arrange
		Product data = new Product("test", 1999, 1000);
		//data.setId(1);
		Product created = dao.save(data);
		int id = created.getId();
		//Act and Assert
		mvc.perform(get("/products/{id}", id).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(id)));
		
	}

}

