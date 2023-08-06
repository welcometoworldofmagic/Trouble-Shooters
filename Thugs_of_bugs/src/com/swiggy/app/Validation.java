package com.swiggy.app;

public class Validation {
	
	public static boolean mobile(long n) {
	 String s=""+n;
	 int count=0;
	 if(s.length()==10) {
		 for(int i=0;i<s.length();i++) {
			 if(s.charAt(0)>='7'&&s.charAt(0)<='9'&&count==0) {
				 count++;
			 }
			 else if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
				 count++;
			 }
		 }
		 if(count==10) {
			 return true;
		 	}
		 	else
			 return false;
		 
	 	}
	 	else
		 return false;
 	}
 
 	public static boolean password(String s) {
	 	if(s.length()<8) {
	 		System.out.println("\nPassword must be 8 or more than 8 characters in length.");
	 		return false;
	 	}
	 	int upper=0,lower=0,num=0,spec=0;
	 	for(int i=0;i<s.length();i++) {
	 		char ch=s.charAt(i);
	 		if(ch>='A'&&ch<='Z') {
	 			upper++;
	 		}
	 		if(ch>='0'&&ch<='9') {
	 			num++;
	 		}
	 		if(ch>='a'&&ch<='z') {
	 			lower++;
	 		}
	 		if(ch=='@'||ch=='#'||ch=='$'||ch=='%') {
	 			spec++;
	 		}
	 	}
	 	if(upper>0&&lower>0&&num>0&&spec>0) {
	 		return true;
	 	}
	 	System.out.println("\nPassword must have atleast one uppercase character,one number,one lowercase character & one special character among (@#$%)");
	 	return false;
 	}
 
 	public static boolean email(String s) {
 		int id=0,atrate=0,dot=0,dom=0;
 		for(int i=0;i<s.length();i++) {
 			char ch=s.charAt(i);
 			if((ch>='A'&&ch<='Z'||ch>='a'&&ch<='z'||ch>='0'&&ch<='9')&&atrate==0) {
 				id++;
 			}
 			else if(ch=='@') {
 				atrate++;
 			}
 			else if((ch>='A'&&ch<='Z'||ch>='a'&&ch<='z')&&ch!='.') {
 				dom++;
 			}
 			else if(s.contains(".com")||s.contains(".co.in")||s.contains(".com")||s.contains(".in")||s.contains(".co")||s.contains(".org")) {
 				dot++;
 				break;
 			}
 		}
 		if(id>3&&atrate==1&&dom>3&&dot==1) {
 			return true;
 		}
 		else
 			System.out.println("\nInvalid Mailid!");
 			return false;
 	}
}
