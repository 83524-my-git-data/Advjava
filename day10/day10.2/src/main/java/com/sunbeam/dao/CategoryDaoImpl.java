package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNewCategory(Category category) {
		String mesg = "adding category failed";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(category);
			tx.commit();// dml - insert
			mesg = "added new category with id " + category.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public Category getCategoryDetailsByName(String categoryName) {
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return null;
	}

}
