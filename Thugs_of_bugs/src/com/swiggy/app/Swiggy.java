package com.swiggy.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Swiggy {
	
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 System.out.println("**************** Welcome To Swiggy ****************");
	     System.out.println("===================================================");
	     System.out.println("                      1.Buyer                      ");
	     System.out.println("                      2.Seller                     ");
	     System.out.println("                      3.Exit                       ");
	     System.out.println("===================================================");
	     System.out.print("\nEnter Your Choice --> ");
	     int ch=sc.nextInt();
	     switch(ch) {
	     case 1:
	    	 Buyer.buyerlog();
             break;

         case 2:// Burger
             

             break;

         case 3:
             break;

         default:
             break;

	     }
	}

}
