package com.swiggy.app;

import java.util.Scanner;
import java.sql.*;

public class Buyer {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void buyerlog() throws ClassNotFoundException, SQLException {
		
		 System.out.println("\n**************** Buyer Login/Signup ***************");
	     System.out.println("===================================================");
	     System.out.println("                      1.Login                      ");
	     System.out.println("                      2.Signup                     ");
	     System.out.println("                      3.Back                       ");
	     System.out.println("                      4.Exit                       ");
	     System.out.println("===================================================");
	     System.out.print("\nEnter Your Choice --> ");
	     int ch=sc.nextInt();
	     switch(ch) {
	     case 1:
	    	 blogin();
             break;

         case 2:
             bsignup();
             break;

         case 3:
        	 System.out.println();
        	 Swiggy.main(null);
             break;
         
         case 4:
        	 break;

         default:
             break;

	     }
	}
	
	public static void blogin() throws ClassNotFoundException, SQLException {
		System.out.println("\n******************* Buyer Login *******************");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/troubleshooters", "root", "root");
		PreparedStatement ps=con.prepareStatement("select password from buyer_details where mobile=?");
		System.out.print("\nEnter your Phone No : ");
		long bid=sc.nextLong();
		System.out.print("\nEnter your Password : ");
		String bpwd=sc.next();
		ps.setLong(1, bid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		String fpwd=rs.getString(1);
			if(fpwd.equals(bpwd)) {
			resType();
			}
			else {
				System.out.println("\nInvalid Paasword!");
			}
		}
		else {
			System.out.println("\nInvalid Credentials!");
		}
	}
	public static void bsignup() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/troubleshooters", "root", "root");
		PreparedStatement ps=con.prepareStatement("insert into buyer_details values(?,?,?,?)");
		System.out.println("\n******************* Buyer Signup ********************");
		System.out.print("\nEnter your Name     : ");
		String bname=sc.next();
		String bid="";
		while(true) {
			System.out.print("\nEnter your MailId   : ");
			bid=sc.next();
			if(Validation.email(bid)) {
				break;
			}
		}
		long bph=0;
		while(true) {
			System.out.print("\nEnter your Ph.No    : ");
			bph=sc.nextLong();
			if(Validation.mobile(bph)) {
				break;
			}
			System.out.println("\nInvalid Ph.No!");
		}
		String bpwd="";
		while(true) {
			System.out.print("\nEnter your Password : ");
			bpwd=sc.next();
			if(Validation.password(bpwd)) {
				break;
			}
		}
		ps.setString(1, bname);
		ps.setString(2, bid);
		ps.setLong(3, bph);
		ps.setString(4, bpwd);
		ps.execute();
		System.out.print("\nAccount created successfully.\n");	
		blogin();
	}
	
	public static void resType() {
		 System.out.println("\n**************** Restaurant Type *****************");
	     System.out.println("==================================================");
	     System.out.println("                    1.Veg                         ");
	     System.out.println("                    2.Non-Veg                     ");
	     System.out.println("                    3.Exit                        ");
	     System.out.println("==================================================");
	     System.out.print("\nEnter Your Choice --> ");
	}
}
