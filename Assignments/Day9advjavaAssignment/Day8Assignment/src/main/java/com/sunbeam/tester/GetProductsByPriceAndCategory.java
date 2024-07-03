package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

public class GetProductsByPriceAndCategory {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);	
				){
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter price min range");
			double min = sc.nextDouble();
			
			System.out.println("Enter price max renge");
			double max = sc.nextDouble();
			
			System.out.println("Enter product category");
			Category category = Category.valueOf(sc.next().toUpperCase());
			
			dao.getProductByPriceAndCategory( min,  max,  category)
			.forEach(System.out::println);
			}catch (Exception e) {
				e.printStackTrace();
			}

}
}
