package com.assessment.controller;

import java.util.*;

import javax.persistence.EntityManagerFactory;

import com.assessment.dao.ProductDao;
import com.assessment.model.ProductStore;

public class Main {
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		
			Scanner sc=new Scanner(System.in);
			System.out.println("1. Enter Product Details ");
			System.out.println("2. Update Product Details");
			System.out.println("3. Delete Product ");
			System.out.println("4. View All Products ");
			System.out.println("\nEnter Choice: ");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Product Name: ");
				String prodname=sc.nextLine();
				System.out.println("Enter Product Description: ");
				String proddesc=sc.nextLine();
				System.out.println("Enter Product Quantity: ");
				int prodquant=sc.nextInt();
				System.out.println("Enter Product Price: ");
				int prodprice=sc.nextInt();
				
				ProductStore ps=new ProductStore(prodname, proddesc, prodquant, prodprice);
				ProductDao pDao=new ProductDao();
				pDao.create(ps);
				
				System.out.println("Product Details recorded!!");
				break;
			
			case 2:
				System.out.println("Enter Id to be updated: ");
				int updateid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Updated Product Name: ");
				String updatename=sc.nextLine();
				System.out.println("Enter Updated Product Quantity: ");
				int updatequant=sc.nextInt();
				System.out.println("Enter Updated Product Price: ");
				int updateprice=sc.nextInt();
				
				ProductDao pDao1=new ProductDao();
				pDao1.update(updateid, updatename,updateprice, updatequant);
				System.out.println("Updated Product Details recorded!!");
				
				break;
			case 3:
				System.out.println("Enter the ID");
				Scanner sc1= new Scanner(System.in);
				long id1= sc1.nextLong();
				ProductDao pDao2= new ProductDao();
				pDao2.delete(id1);
				System.out.println("Deleted");
				break;
			case 4:
				ProductDao p4= new ProductDao();
				List<ProductStore> product= p4.findAll();
				for (ProductStore product2 : product) {
					System.out.println(product2.getProdname()+" "+product2.getProddesc()+" "+product2.getProdquant()+" "+product2.getProdprice()+" " );
				}
			}
		}

			
		
	}

}
