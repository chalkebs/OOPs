package com.bridgelab.oops;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* StockAccount.java implements a data type that
might be used by a financial institution to keep track of customer information. The
StockAccount class implements following methods
The StockAccount class also maintains a list of CompanyShares object which has
Stock Symbol and Number of Shares as well as DateTime of the transaction. When
buy or sell is initiated StockAccount checks if CompanyShares are available and
accordingly update or create an Object. */

interface methods
{
	void valueof(double d1) throws IOException;
	ArrayList<String> buy(double amount,ArrayList<String> symbol,ArrayList<String> s3);
	void sell(double d1,String s5,ArrayList<String> s3) throws IOException;
	void printReport() throws Exception;
}

public class StockAccount implements methods
{
	static Scanner s=new Scanner(System.in);
	
	StockAccount()
	{
		
	}
	StockAccount(String filename)
	{
		 Random rand = new Random();
		 try 
		 {
	         File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/"+filename+".txt");
	         
	         if(file.createNewFile())
	         {
	        	 FileWriter fr = new FileWriter(file, true);
	        	 fr.write("User Name:"+filename+"\n");
	        	 
	        	 System.out.println("Enter Company name:");
				 String cn=s.next();
				 fr.write("Company Name:"+cn+"\n");
				 System.out.println();
				 
				 fr.write("Your Account no. :"+rand.nextInt(1000)+"\n");
	        	 fr.close();
	        	 
	        	 System.out.println("Account is Created...");
	         }
	         else System.out.println ("Error, file already exists.");
	      }
	      catch(IOException ioe) {
	         ioe.printStackTrace();
	      }	
	}

	public static void main(String[]args) throws Exception
	{
		char c;
		StockAccount sa1=new StockAccount();
		int choice;
		ArrayList<String> s3=new ArrayList<String>();
		s3.add("Reliance");
		s3.add("BSNL");
		s3.add("Idea");
		s3.add("Vodafone");
		s3.add("Google");
		double d1 = 0;
		ArrayList<String> s2=new ArrayList<String>();
		System.out.println("*** Stock Account ***");
		do
		{
			System.out.println("1. Create Account\n2. Check Balance\n3. Buy Shares\n4. Sell Shares\n5. Generate Report\n");
			System.out.println("Enter your choice...");
			choice=s.nextInt();

			switch(choice)
			{
				case 1:
					System.out.println("Enter your Name :");
					String s1=s.next();
					@SuppressWarnings("unused") 
					StockAccount sa=new StockAccount(s1);
					break;
				case 2:
					Random rand = new Random();
					double d=rand.nextInt(10000000);
					d1=d/61.06;
					sa1.valueof(d1);
					break;
				case 3:
					System.out.println("Enter Amount :");
					double amount=s.nextInt();
					System.out.print("\n"+s3);
					System.out.println("\n\nEnter which shares you want to buy");
					s2.add(s.next());
					d1=d1-amount;
					s3=sa1.buy(d1, s2, s3);
					break;
				case 4:
					System.out.println("Enter Amount :");
					double amount1=s.nextInt();
					System.out.print("\n"+s2);
					System.out.println("\nEnter which shares you want to sell");
					String s5=s.next();
					s3.add(s5);
					d1=d1+amount1;
					System.out.println(s3+"\n");
					sa1.sell(d1,s5,s3);
				case 5:
					sa1.printReport();
					
				default:
					System.out.println("Invalid Input...");
			}
			System.out.println("\nEnter y for performing more operations...?");
			c=s.next().charAt(0);
		}
		while(c=='Y'||c=='y');
	}
	
	public void valueof(double d1) throws IOException
	{
		System.out.println("\nEnter your username:");
		String s1=s.next();
		File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/"+s1+".txt");
		FileWriter fr = new FileWriter(file, true);
		fr.write("Stock Balance : "+d1+" $\n");
		fr.write("\n");
		System.out.println("\nYour stock balance is:"+d1+" $");	
		fr.close();
	}

	public ArrayList<String> buy(double amount, ArrayList<String> symbol, ArrayList<String> s3)
	{
		System.out.println("\nEnter your username:");
		String s1=s.next();
		try
		{
			File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/"+s1+".txt");
			FileWriter fr = new FileWriter(file, true);
			fr.write("Share :"+symbol+"\n"+"Current Balance :"+amount);
			int index=s3.indexOf(symbol.get(0));
			s3.remove(index);
			fr.write("\n");
			fr.close();
			System.out.println("\nCurrent Balance is :"+amount);
			System.out.println("\nfile saved...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s3;
	}

	public void sell(double d1,String s5,ArrayList<String> s3) throws IOException
	{
		System.out.println("Enter your username:");
		String s1=s.next();
		File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/"+s1+".txt");
		FileWriter fr = new FileWriter(file, true);	 
    	fr.write("Share sold : "+s5+"\nCurrent Balance : "+d1);	
		System.out.println("file saved....");
		fr.write("\n");
		fr.close();
	}

	public void printReport() throws Exception
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter User Name :"); 
		String s1=s.nextLine();
		File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/"+s1+".txt"); 
	    Scanner sc = new Scanner(file);
	    sc.useDelimiter("\\Z"); 
	    System.out.println();
	    System.out.println(sc.next()); 
	}
}
