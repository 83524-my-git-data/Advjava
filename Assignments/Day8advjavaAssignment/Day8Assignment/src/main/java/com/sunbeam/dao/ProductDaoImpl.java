package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import com.sunbeam.entities.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String addproduct(Product product) {
		String mesg="product did not get added!!!!";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			Serializable Id = session.save(product);
			tx.commit();
			mesg="product added successfully , with ID"+Id;
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	
	

	@Override
	public Product getProductById(Long Id) {
		Product product=null;
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			product=session.get(Product.class, Id);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
		
			throw e;
		}
		return product;
	}
}
