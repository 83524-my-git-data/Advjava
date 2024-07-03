package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {

	List<Product>getProductByPriceAndCategory(double min, double max, Category Productcategory);

	
}
