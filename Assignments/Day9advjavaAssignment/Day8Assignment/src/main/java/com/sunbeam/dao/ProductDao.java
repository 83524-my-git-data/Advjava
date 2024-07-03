package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {

	String addproduct(Product product);
	Product getProductById(Long Id);
	List<Product>displayAllProducts();
	List<Product>getProductByPriceAndCategory(double min, double max, Category category);
	String applyDiscount(Category category, double discount);
	String deleteProductDetails(String productname);
	String purchaseProduct(Long Id, int availablequantity);
}
