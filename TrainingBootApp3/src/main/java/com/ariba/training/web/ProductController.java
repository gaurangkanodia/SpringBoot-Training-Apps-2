package com.ariba.training.web;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ariba.training.domain.Product;
import com.ariba.training.service.ProductService;

@RestController
public class ProductController {

	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired 
	ProductService ps;
	
	@RequestMapping(method=RequestMethod.GET, value="/products")
	public List<Product> getAll()
	{
		return ps.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/products/{pid}")
	public ResponseEntity<?> getById(@PathVariable("pid") int id)
	{
		Product p = ps.findById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(p,HttpStatus.OK);
			
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public ResponseEntity<?> addProduct(@RequestBody Product p)
	{
		try {
			int id = ps.createNewProduct(p);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/products"+id));
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> updateProduct(int id, Product updated)
	{
		Product existing = ps.findById(id);
		if(existing == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			existing.setName(updated.getName());
			existing.setPrice(updated.getPrice());
			existing.setQoh(updated.getQoh());
			ps.update(existing);
			return new ResponseEntity<>(ps,HttpStatus.OK);
			
		}
		
	}

}
