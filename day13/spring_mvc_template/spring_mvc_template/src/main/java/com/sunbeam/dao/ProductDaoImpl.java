package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	
	private SessionFactory factory;

	@Override
	public List<Product> getProductByPriceAndCategory(double min, double max, Category Productcategory) {
		String jpql="select p from BlogPost p where p.selectedCategory.categoryName =:cat";
		return factory.getCurrentSession().createQuery(jpql,Product.class).setParameter("cat",Productcategory).getResultList();
	}
	
}
