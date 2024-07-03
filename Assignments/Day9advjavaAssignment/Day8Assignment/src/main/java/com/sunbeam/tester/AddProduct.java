package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			//create dao instance
			ProductDao dao=new ProductDaoImpl();
			System.out.println("Enter Product details -category, productname, double price, int availablequantity");
			Product newProduct=new Product(Category.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addproduct(newProduct));
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
