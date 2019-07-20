package com.bridgelab.oops;

public class Address
{
	String FirstName,LastName,Address,state,city,Zip,phoneNo;
		
		public String getFirstName() 
		{
			return FirstName;
		}
		public void setFirstName(String fn) 
		{
			this.FirstName = fn;
		}
		public String getLastName() 
		{
			return LastName;
		}
		public void setLastName(String ln)
		{
			this.LastName = ln;
		}
		public String getAddress()
		{
			return Address;
		}
		public void setAddress(String ad) 
		{
			this.Address = ad;
		}
		public String getState()
		{
			return state;
		}
		public void setState(String st) 
		{
			this.state = st;
		}
		public String getCity()
		{
			return city;
		}
		public void setCity(String c) 
		{
			this.city = c;
		}
		public String getZip()
		{
			return Zip;
		}
		public void setZip(String z) 
		{
			this.Zip = z;
		}
		public String getPhoneNo()
		{
			return phoneNo;
		}
		public void setPhoneNo(String pn) 
		{
			this.phoneNo = pn;
		}
		
		@Override
		public String toString() {
	        return ("First Name :"+this.getFirstName()+
	                    "\nLast Name :"+ this.getLastName() +
	                    "\nAddress :"+ this.getAddress() +
	                    "\nState :" + this.getState() +
	                    "\nCity :" +this.getCity() +
	                    "\nZip :" +this.getZip() +
	                    "\nPhone No. :" +this.getPhoneNo());
	   }
}
