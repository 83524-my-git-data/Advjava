package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		String mesg="adding product failed!!!!!!!";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get category from it's id -
			Category category=session.get(Category.class, categoryId);
			if(category != null)
			{
				//valid category - persistent
				//4. establish bi dir association between Category n Product
				category.addProduct(newProduct);//state of the category(persistent) is changed !
			//	session.persist(newProduct);//Is this required ??????? NO
				mesg="added the product !";
			}
			tx.commit();
			/*
			 * session.flush() -> dirty chking -> 
			 * category is modified -> new product entity added .
			 * hib : inserts the product
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

}
