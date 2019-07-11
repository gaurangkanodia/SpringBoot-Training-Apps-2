package com.ariba.training.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ariba.training.dal.ProductDAO;
import com.ariba.training.domain.Product;

/*
 * This Test is an out-of-container test example.
 * Spring Framework, Aspects, etc are excluded.
 * The method is tested as a simple POJO.
 */

@RunWith(MockitoJUnitRunner.class) //After adding @Mock
public class ProductServiceImplTest {

	public ProductServiceImplTest() {
		
	}
	@Mock
	ProductDAO mockDAO;
	
	@Before
	public void commonTrainingForMockDAO()
	{
		/*
		 * Method with @Before annotation will run everytime
		 * before each @Test
		 */
	}
	
	@Test
	public void createNewProduct_Must_Return_Valid_Id_When_Value_GT_Min_Value()
	{
		//Arange
		ProductServiceImpl service = new ProductServiceImpl();
		Product testData = new Product("test", 100000, 10);
//		ProductDAO mockDAO = Mockito.mock(ProductDAO.class); @Mock used instead
		Product created = new Product("test",100000,10);
		created.setId(1);
		Mockito.when(mockDAO.save(testData)).thenReturn(created);
		service.setProductDao(mockDAO);
		
		//Act
		int id = service.createNewProduct(testData);
		
		//Assert
		assertTrue(id>0);
	}

}
