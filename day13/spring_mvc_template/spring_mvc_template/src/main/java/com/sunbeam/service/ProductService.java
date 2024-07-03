package com.sunbeam.service;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductService {

	List<Product>getProductByPriceAndCategory(double min, double max, Category Productcategory);
	
}
