package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.*;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mesg = "adding product failed!!!!!!!";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. get category from it's id -
			Category category = session.get(Category.class, categoryId);
			if (category != null) {
				// valid category - persistent
				// 4. establish bi dir association between Category n Product
				category.addProduct(newProduct);// state of the category(persistent) is changed !
				// session.persist(newProduct);//Is this required ??????? NO
				mesg = "added the product !";
			}
			tx.commit();
			/*
			 * session.flush() -> dirty chking -> category is modified -> new product entity
			 * added . hib : inserts the product
			 * 
			 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = null;
		String jpql = "select p from Product p";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			products = session.createQuery(jpql, Product.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return products;
	}

	@Override
	public Product getProductDetails(Long productId) {
		Product product = null;
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			product = session.get(Product.class, productId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return product;
	}

	@Override
	public String purchaseProduct(Long productId, int qty) {
		String mesg = "purchase product failed !";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			Product product = session.get(Product.class, productId);
			if (product != null && product.getAvailableQty() >= qty) {
				product.setAvailableQty(product.getAvailableQty() - qty);
				mesg = "product purchased!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}
