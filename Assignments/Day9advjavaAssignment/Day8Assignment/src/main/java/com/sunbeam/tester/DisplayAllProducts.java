package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class DisplayAllProducts {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()){
			ProductDao dao = new ProductDaoImpl();
			dao.displayAllProducts()
			.forEach(System.out::println);
		}
catch(Exception e) {
	e.printStackTrace();
}
	}

}
