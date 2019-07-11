package com.ariba.training.dal;

import java.util.List;

import com.ariba.training.domain.Product;

public interface ProductDAO 
{
	public Product save(Product p);
	public Product findById(int id);
	public List<Product> findAll();

}
