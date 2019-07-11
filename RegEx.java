package com.bridgelab.oops;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx 
{
	static String firstnm,fullnm,mobileno,date;
	static String s3="Hello <<name>>,\nWe have your full name as <<full name>> in our system."
			+ "\nYour contact number is 91-xxxxxxxxxx.\nPlease,let us know in case of any" + 
			" clarification. \nThank you BridgeLabz XX/XX/XXXX.";
	public static void main(String[]args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Your first name :");
		firstnm=s.nextLine();
		System.out.println("Enter Your full name :");
		fullnm=s.nextLine();
		System.out.println("Enter Your mobile no. :");
		mobileno=s.nextLine();
		System.out.println("Enter date as dd/mm/yyyy :");
		date=s.nextLine();
		
		regex("<<name>>", firstnm);	
		regex("<<full name>>", fullnm);	
		regex("xxxxxxxxxx", mobileno);	
		regex("XX/XX/XXXX", date);	
		System.out.println(s3);	
	}
	
	private static void regex(String s1 , String s2) {
		Pattern p = Pattern.compile(s1);	//	pattern
		Matcher m= p.matcher(s3);	//	matcher
		s3= m.replaceFirst(s2);
	}
}
