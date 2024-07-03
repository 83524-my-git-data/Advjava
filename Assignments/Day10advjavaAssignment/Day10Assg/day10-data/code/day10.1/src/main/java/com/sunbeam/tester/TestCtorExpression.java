package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Role;

public class TestCtorExpression {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter  role");
			dao.testJPACtorExpression(
					Role.valueOf(sc.next().toUpperCase()))
			.forEach(u -> System.out.println(u.getFirstName()+" "+u.getLastName()+" "+u.getDob()));//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
