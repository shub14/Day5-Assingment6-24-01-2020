package com.robomq.ecomUI;

import java.util.Scanner;
import java.sql.ResultSet;

import com.robomq.pojo.Customer;
import com.robomq.service.CustomerService;
import com.robomq.service.CustomerServiceImpl;

public class EcommerceUI {

	Customer c;
	Scanner sc;
	CustomerService service;
	public EcommerceUI()
	{
		sc=new Scanner(System.in);
		c=new Customer();
		service=new CustomerServiceImpl();
	}
	public void registerCustomer()
	{
		System.out.println("Enter Customer id.");
		c.setId(sc.nextInt());
		System.out.println("Enter Customer Name.");
		c.setName(sc.next());
		System.out.println("Enter Customer email.");
		c.setEmail(sc.next());
		System.out.println("Enter Customer address.");
		c.setAddress(sc.next());
		System.out.println("Enter Customer Mobileno.");
		c.setMobileno(sc.next());
		if(service.createCustomer(c))
			System.out.println("Customer registered successfully...");
		else
			System.out.println("Customer Not registered ...");
		
		
	}
	public void loginCustomer() {
		System.out.println("enter the customer id");
		c.setId(sc.nextInt());
		System.out.println("enter the customer name");
		c.setName(sc.next());
		ResultSet res= service.loginCustomer(c);
		try {
			if(res.next()!=false)
				System.out.println("Login Successfull");
			else
				System.out.println("customer not found!!,PLEASE REGISTER\n\n");
					this.registerCustomer();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateCustomer() {
		System.out.println("please type the id of the customer you want update");
		c.setId(sc.nextInt());
		System.out.println("enter the new email");
		c.setEmail(sc.next());
		System.out.println("enter the new address");
		c.setAddress(sc.next());
		System.out.println("enter the new mobile no.");
		c.setMobileno(sc.next());
		if(service.updateCustomer(c)==true)
			System.out.println("Customer Details updated succesfully");
		else
			System.out.println("Sorry customer details not updated");
	}
	public void viewCustomer() {
		System.out.println("please type the id of the customer you want view");
		c.setId(sc.nextInt());
		ResultSet res=service.displayCustomer(c);
		try {
		while(res.next()) {
			System.out.println("Id: " +res.getInt(1));
			System.out.println("Name: " +res.getString(2));
			System.out.println("Mobile no.: " +res.getString(3));
			System.out.println("Address: " +res.getString(4));
			System.out.println("Email: " +res.getString(5));
			System.out.println(" ");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCustomer() {
		System.out.println("please type id of the customer you want to delete");
		c.setId(sc.nextInt());
		if(service.deleteCustomer(c)==true) 
			System.out.println("Customer record deleted");
		else 
			System.out.println("Customer Record deletion unsuccessful");		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ch=null;
		EcommerceUI e=new EcommerceUI();
		while(true)
		{
			System.out.println("Enter Your Choice");
			System.out.println("1. Registring New Customer");
			System.out.println("2. Login Customer");
			System.out.println("3. View Existing Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Update Customer");
			System.out.println("6. Exit");
			ch=sc.next();
			switch(ch)
			{
				case "1":
				{
					e.registerCustomer();
					break;
				}
				case "2":
				{
					e.loginCustomer();
					break;
				}
				case "3":
				{
					e.viewCustomer();
					break;
				}
				case "4":
				{
					e.deleteCustomer();
					break;
				}
				case "5":
				{
					e.updateCustomer();
					break;
				}
				case "6":
				{
					System.exit(0);
				}
			}
		}
	}

}
