package com.sunbeam.dao;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
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



	@Override
	public List<Product> displayAllProducts() {
		String jpql = "select p from Product p";
		List<Product>products = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx !=null)
				tx.rollback();
			throw e;
		}
		return products;
	}



	@Override
	public List<Product> getProductByPriceAndCategory(double min, double max1, Category category) {
	  String jpql = "select p from Product p where p.price between :min and :max and p.category=:ca";
	  List<Product>products = null;
	  Session session = getFactory().getCurrentSession();
	  Transaction tx = session.beginTransaction();
	  try {
		  products = session.createQuery(jpql, Product.class).setParameter("min",min).setParameter("max",max1)
		  .setParameter("ca", category).getResultList();
		  tx.commit();
	  }catch(RuntimeException e) {
		  if(tx !=null)
			  tx.rollback();
		  throw e;
	  }
		return products;
	}



	@Override
	public String applyDiscount(Category category, double discount) {
		String mesg = "applying discount failed !!!";
		String jpql = "update Product p set p.price = p.price - :disc where p.category=:ct";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("ct", category)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount to products - " + rows;
		}catch(RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}



	@Override
	public String deleteProductDetails(String productname) {
	    String mesg = "deletion failed";
	    String jpql = "delete from Product p where p.productname=:pt";
	    Session session = getFactory().getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    try {
	        int result = session.createQuery(jpql)
	                            .setParameter("pt", productname)
	                            .executeUpdate();
	        tx.commit();
	        if (result > 0) {
	            mesg = "Product deleted successfully!";
	        }
	    } catch(RuntimeException e) {
	        if(tx !=null)
	            tx.rollback();
	        throw e;
	    }
	    return mesg;
	}


  
	@Override
	public String purchaseProduct(Long id, int availablequantity) {
	    String mesg = "Purchase failed";
	    Session session = getFactory().getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    try {
	        
	        Product product = session.get(Product.class, id);
	        
	        if (product == null) {
	            mesg = "Product not found!";
	        } else if (product.getAvailablequantity() < availablequantity) {
	            mesg = "Insufficient stock!";
	        } else {
	            
	            product.setAvailablequantity(product.getAvailablequantity() - availablequantity);
	            session.update(product);
	            tx.commit();
	            mesg = "Product purchased successfully!";
	        }
	    } catch (RuntimeException e) {
	        if (tx != null)
	            tx.rollback();
	        throw e;
	    }
	    return mesg;
	}


}