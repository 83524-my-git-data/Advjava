package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
//add a product
	String addProduct(Long categoryId, Product newProduct);
}
