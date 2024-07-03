package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;

public class DeleteUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user id for deleting the use details");
			System.out.println(dao.deleteUserDetails(sc.nextLong()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
