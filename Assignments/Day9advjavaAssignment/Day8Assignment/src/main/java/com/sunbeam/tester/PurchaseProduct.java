package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class PurchaseProduct {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory();
             Scanner scanner = new Scanner(System.in)) {
            
       
            System.out.print("Enter product ID: ");
            Long id = (long) scanner.nextInt();

            System.out.print("Enter quantity to purchase: ");
            int availablequantity = scanner.nextInt();

           
            ProductDao dao = new ProductDaoImpl();
            
            
            String result = dao.purchaseProduct(id, availablequantity);
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


