package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	Product findBycompanyName1(String name);
	
	

}
