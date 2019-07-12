package com.bridgelab.oops;
import java.util.Scanner;

public class Stockportfolio 
{
	private static LinkedList<Stockportfolio> list;
	private String nm;
	private int noOfShares, p;
	
	public Stockportfolio(String nm , int noOfShares, int p) 
	{
		this.nm = nm;
		this.noOfShares = noOfShares;
		this.p = p;
	}
	
	public static void main(String[] args)
	{
		getStockData();
		printReport();
	}
	private static void getStockData() 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of stocks : ");
		int c = scanner.nextInt();
		list = new LinkedList<Stockportfolio>();
		
		for(int i = 0; i < c; i++) 
		{
			System.out.print("Enter stock name : ");
			String nm = scanner.next();
			System.out.print("Enter no. of shares : ");
			int noOfShares = scanner.nextInt();
			System.out.print("Enter share price : ");
			int p = scanner.nextInt();
			Stockportfolio st = new Stockportfolio(nm, noOfShares, p);
			list.add(st);
		}
		scanner.close();
	}
	
	private static void printReport() 
	{
		int totalValue = 0;
		System.out.println("\nName\tShares\tPrice\tValue");
		while(!list.isEmpty()) 
		{
			Stockportfolio sr = list.pop(0);
			totalValue = totalValue +sr.getValue();
			System.out.println(sr.getName()+"\t"+sr.getNumberOfShares()+"\t"+sr.getPrice()+ " \t" +sr.getValue());
		}
		System.out.println("\nTotal value is: " + totalValue);
	}
	
	public int getValue()
	{
		return noOfShares * p;
	}
	
	public String getName()
	{
		return nm;
	}
	public int getNumberOfShares()
	{
		return noOfShares;
	}
	public int getPrice()
	{
		return p;
	}
}
