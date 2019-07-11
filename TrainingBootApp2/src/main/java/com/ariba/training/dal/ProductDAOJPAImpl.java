package com.ariba.training.dal;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ariba.training.domain.Product;

@Transactional
@Component
public class ProductDAOJPAImpl implements ProductDAO{
	
	@Autowired
	EntityManager em;

	public ProductDAOJPAImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product save(Product p) {
		em.persist(p);
		return p;
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return em.createQuery("select p from Product p").getResultList();
	}

}
