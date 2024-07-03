package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter date n discount amount");
			System.out.println(dao.
					applyDiscount(
							LocalDate.parse(sc.next()), sc.nextDouble()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
