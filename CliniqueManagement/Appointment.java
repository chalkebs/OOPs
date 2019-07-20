package com.bridgelab.oops;

public class Appointment 
{
	String nameDR,namePt;
	
	public String getNameDR() 
	{
		return nameDR;
	}
	public void setNameDR(String nd) 
	{
		this.nameDR = nd;
	}
	public String getNamePt() 
	{
		return namePt;
	}
	public void setNamePt(String np) 
	{
		this.namePt= np;
	}
	@Override
	public String toString() 
	{
		return (" Name of Doctor :"+this.getNameDR()+
		        "\n Name of Patient :"+ this.getNamePt());
	}
}
