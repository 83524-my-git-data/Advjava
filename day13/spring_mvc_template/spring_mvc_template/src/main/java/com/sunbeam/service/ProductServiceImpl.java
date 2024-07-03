package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductDao productDao;
	
@Override
	public List<Product> getProductByPriceAndCategory(double min, double max, Category Productcategory) {
		
		return productDao.getProductByPriceAndCategory(min, max, Productcategory);
}		
}
	
