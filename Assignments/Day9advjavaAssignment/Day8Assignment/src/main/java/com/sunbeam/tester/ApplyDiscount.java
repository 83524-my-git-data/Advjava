package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter discount amount");
			double price = sc.nextDouble();
			
			System.out.println("Enter category");
			Category category = Category.valueOf(sc.next().toUpperCase());
			
			System.out.println(dao.applyDiscount(category, price));

	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}
}
