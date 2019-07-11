package com.ariba.training.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ariba.training.dal.ProductDAO;
import com.ariba.training.dal.ProductRepository;
import com.ariba.training.domain.Product;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

	public ProductServiceImpl() 
	{	
		/*
		 * List<Product> productList = productDao.findAll();
		 * System.out.println("There are "+productList.size()+" products in the DB.");
		 * 
		 * This will not run as the Autowiring is done after the instantiation of the Bean
		 * Therefore to do so we keep the constructor empty and use @PostConstuct on a method. This tells
		 * spring to call the method as soon as the defult contuctor is called.
		 * 
		 * */
	}
	
	@Qualifier("productDAOJPAImpl")
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void init()
	{
		List<Product> productList = productDao.findAll();
		System.out.println("There are "+productList.size()+" product(s) in the DB.");
	}
	
	@Override
	public int createNewProduct(Product p)
	{
		if(p.getPrice()*p.getQoh() < 10000)
		{
			throw new IllegalArgumentException("Value too low");
		}
		else
		{
			Product created = productDao.save(p);
			return created.getId();
		}
	}

	@Override
	public Product findById(int id) {
//		return productDao.findById(id);
		Optional<Product> p = productRepository.findById(id);
		return p.get();
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public void changePrice(int pid, float newPrice) {
		Product p = productDao.findById(pid);
		if(p != null) {
			p.setPrice(newPrice);
		}
		
	}

	@Override
	public void update(Product existing) {
		productRepository.save(existing);
		
	}

	
	
	

}
