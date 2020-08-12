package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prd)
	{
		return service.saveProduct(prd);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> prds)
	{
		return service.saveProduct(prds);
	}
	
	@GetMapping(path="/getProduct/{id}")
	public Product getProduct(@PathVariable int id)
	{
		return service.getProductbyID(id);
	}
	
	@GetMapping(path="/getHello")
	public String getHello()
	{
		return "Chitta";
	}
	
	
	@GetMapping("/getProductbyName/{name}")
	public Product getProductByName(@PathVariable String name)
	{
		System.out.println("---Name---"+name);
		return service.getProductbyName(name);
	}
	
	
	@GetMapping("/getProductByCompany/{name}")
	public Product getProductByCompany(@PathVariable String name)
	{
		return service.getProductByCompany(name);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getAllProducts()
	{
		return service.getProducts();
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product prd)
	{
		return service.updateProduct(prd);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}

}
