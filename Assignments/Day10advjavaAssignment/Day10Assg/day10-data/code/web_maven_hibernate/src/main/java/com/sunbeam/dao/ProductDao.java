package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao {
//add a product
	String addProduct(Long categoryId, Product newProduct);
	// get all products
		List<Product> getAllProducts();

		// get product details by id
		Product getProductDetails(Long productId);

		String purchaseProduct(Long productId, int qty);
}
