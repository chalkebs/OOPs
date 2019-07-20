package com.bridgelab.oops;

public class Patient 
{
	String name,ID,mobileNo,age;
			
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
	public String getMobileNo()
	{
		return mobileNo;
	}
	public void setMobileNo(String mb) 
	{
		this.mobileNo = mb;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String ag) 
	{
		this.age = ag;
	}
	@Override
	public String toString() 
	{
		return (" Name :"+this.getName()+
		        "\n ID :"+ this.getID() +
		        "\n MobileNo :"+ this.getMobileNo() +
		        "\n Age :" + this.getAge());
	}
}
