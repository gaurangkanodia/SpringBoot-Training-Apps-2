package com.ariba.training.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ariba.training.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	public List<Product> findByName(String name);
	
	public List<Product> findByPriceLessThan(float price);
	
	@Query("select p from Product p where p.qoh <10")
	public List<Product> myComplexQuery();
}
