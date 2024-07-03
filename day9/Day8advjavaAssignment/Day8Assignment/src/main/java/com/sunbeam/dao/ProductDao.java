package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {

	String addproduct(Product product);
	Product getProductById(Long Id);
}
