package com.bridgelab.oops;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Details
{
	/*first and last names, address, city, state, zip, and
	phone number*/
	String first_name,last_name,address,city,state,zip,phone_no;
	Details(String first_name,String last_name,String address,String city,String state,String zip,String phone_no)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_no=phone_no;
	}

	JSONArray toJsonObject() 
	{
		JSONObject obj = new JSONObject();
		obj.put("First Name", first_name);
		obj.put("Last Name", last_name);
		obj.put("Address", address);
		obj.put("City", city);
		obj.put("State", state);
		obj.put("Zip", zip);
		obj.put("Phone Number", phone_no);
		
		JSONObject obj1 = new JSONObject();
	    obj1.put("User Details", obj);
	    
	    JSONArray list = new JSONArray();
        list.add(obj1);
		
        return list;
	}
}
