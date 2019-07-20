package com.bridgelab.oops;

public class Doctor 
{
	String name,ID,specialization,availability1,availability2;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String nm) 
	{
		this.name = nm;
	}
	public String getID() 
	{
		return ID;
	}
	public void setID(String id)
	{
		this.ID = id;
	}
	public String getSpecialization()
	{
		return specialization;
	}
	public void setSpecialization(String sp) 
	{
		this.specialization = sp;
	}
	public String getAvailabilityFrom()
	{
		return availability1;
	}
	public void setAvailabilityFrom(String av) 
	{
		this.availability1 = av;
	}
	public String getAvailabilityTo()
	{
		return availability2;
	}
	public void setAvailabilityTo(String av1) 
	{
		this.availability2 = av1;
	}
	@Override
	public String toString() 
	{
		return (" Name :"+this.getName()+
		        "\n ID :"+ this.getID() +
		        "\n Specialization :"+ this.getSpecialization() +
		        "\n Availability From :" + this.getAvailabilityFrom()+
		        "\n Availability To :" + this.getAvailabilityTo());
	}
}
