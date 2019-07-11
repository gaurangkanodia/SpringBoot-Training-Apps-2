package com.ariba.training.dal;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ariba.training.domain.Product;

@Component
//@Scope("dev"/"session")
public class ProductDAOInMemoryImpl implements ProductDAO
{
	/*
	 * Code is not Thread Safe.
	 * To make thread safe we cannot use HashMap and 
	 * primitive int. Making programme thread safe..
	 */ 
	
//	Map<Integer,Product> db = new HashMap<>();
	Map<Integer,Product> db = new ConcurrentHashMap<>();
//	int idSequence = 0;
	AtomicInteger idSequence = new AtomicInteger(0);
	
	public ProductDAOInMemoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product save(Product p) {
//		int id = ++idSequence;
		int id = idSequence.incrementAndGet();
		p.setId(id);
		db.put(id, p);
		return p;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
