package com.bridgelab.oops;

public class Count 
{
	String nameDR,c;
	
	public String getNameDR() 
	{
		return nameDR;
	}
	public void setNameDR(String nd) 
	{
		this.nameDR = nd;
	}
	public String getCount() 
	{
		return c;
	}
	public void setCount(String i) 
	{
		this.c= i;
	}
	@Override
	public String toString() 
	{
		return (" Name of Doctor :"+this.getNameDR()+
		        "\n Counter :"+ this.getCount());
	}
}
