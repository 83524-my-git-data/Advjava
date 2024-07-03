package com.sunbeam.dao;

import com.sunbeam.entities.User;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		String mesg="user registration failed!!!!";
		// 1. get Session from SessionFactory
		/*
		 * API of SessionFactory 
		 * public Session openSession() throws HibernateException
		 * OR
		 * public Session getCurrentSession() throws HibernateException
		 * SF (session factory) will check for the existing session
		 * If absent , creates n rets it to the caller.
		 * o.w(otherwise) rets the existing session to the caller.
		 * Such a session is auto closed upon
			tx boundary(commit | rollback)	
		 */
		Session session=getFactory().getCurrentSession();
		//2. Begin a transaction
		/*
		 * Session API 
		 * org.hibernate.Transacation beginTransaction() throws HibExc.
		 */
		Transaction tx=session.beginTransaction();
		try {
			//CRUD operation
			/*
			 * Session API 
			 * public Serializable save(Object o) throws HibernateException
			 * 
			 */
			Serializable userId = session.save(user);
			//=> success
			tx.commit();
			mesg="user registered successfully , with ID"+userId;
		} catch (RuntimeException e) {
			// rollback tx
			if(tx != null)
				tx.rollback();
			//re throw the same exc to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public User getUserDetailsById(Long userId) {
		User user=null;
		// 1. Get session from Session Factory
		Session session=getFactory().getCurrentSession();
		//2. Begin Tx
		Transaction tx=session.beginTransaction();
		try {
			/*
			 * Session API for getting entity details by it's id
			 * public <T> T get(Class<T> entityClass,
			 * Serializable id) throws HibernateException
			 * T - type of the entity
			 * Rets - in case of valid id - persistent entity ref
			 * o.w - null
			 */
			user=session.get(User.class, userId);//select
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw same exc to the caller
			throw e;
		}
		return user;
	}
	

}
