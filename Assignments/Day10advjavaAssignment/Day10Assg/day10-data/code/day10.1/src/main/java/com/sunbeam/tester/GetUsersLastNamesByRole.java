package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Role;

public class GetUsersLastNamesByRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in);
				) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter  role");
			dao.getLastNamesByRole(Role.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
