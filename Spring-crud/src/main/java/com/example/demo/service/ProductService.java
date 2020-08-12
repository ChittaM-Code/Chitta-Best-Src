package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.respository.ProductRespository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRespository repository;
	
	public Product saveProduct(Product prd)
	{
		return repository.save(prd);
	}
	
	public List<Product> saveProduct(List<Product> prd)
	{
		return repository.saveAll(prd);		
	}
	
	public List<Product> getProducts()
	{
		return repository.findAll();		
	}
	
	public Product getProductbyID(int id)
	{
		return repository.findById(id).orElse(null);
	}
	public Product getProductbyName(String name)
	{
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Product Removed:"+id;
	}
	
	public Product updateProduct(Product prd)
	{
		Product prdExistingProduct = repository.findById(prd.getId()).orElse(null);
		prdExistingProduct.setName(prd.getName());	
		prdExistingProduct.setQuanity(prd.getQuanity());
		prdExistingProduct.setPrice(prd.getPrice());
		return repository.save(prdExistingProduct);
		
	}

	public Product getProductByCompany(String name) {
		// TODO Auto-generated method stub
		return repository.findBycompanyName1(name);
	}
	
	
	
	
}
