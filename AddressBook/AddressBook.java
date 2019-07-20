package com.bridgelab.oops;

import com.bridgelab.oops.Address;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonInclude(Include.NON_NULL)
public class AddressBook
{
	ObjectMapper objectMapper = new ObjectMapper();
	
	Scanner s=new Scanner(System.in);
	public static void main(String[] args)
	{
		AddressBook ab=new AddressBook();
		ab.choiceOfUser();
	}
	void choiceOfUser()
	{
		char ch = 0;
		do 
		{
			System.out.print("1. Add\n2. Edit\n3. Delete\n4. Sort by Name\n5. Sort by Zip\n6. Print Entries\n7."
					+ " Quit\n");
			System.out.println("Enter Your Choice...");
			int choice=s.nextInt();
			
			switch(choice)
			{
				case 1: addUser();
						break;
				case 2:
						Edit();
						break;
				case 3:
						Delete();
						break;
				case 4:
						sortByName();
						break;
				case 5:
						sortByZip();
						break;
				case 6:
						printEntries();
						break;
				case 7: 
						quit();
						break;
				default:
						System.out.println("\n Invalid Input...");
			}
			System.out.println("\nIf you want to continue then enter y...");
			ch=s.next().charAt(0);
			
		}while(ch=='y'||ch=='Y');			
	}
	
	private void quit() 
	{
		System.exit(0);
	}
	private void printEntries()
	{
		JsonNode array;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			String i = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(array);
			System.out.println(i);
		}
		catch(Exception e)
		{
			
		}
	}
	private void sortByZip()
	{
		JsonNode array;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			
			List<JsonNode> myJsonArrayAsList = new ArrayList<JsonNode>();
			for (int i = 0; i < array.size(); i++)
			{
			    myJsonArrayAsList.add(array.get(i));
			}
			
			Collections.sort(myJsonArrayAsList, new Comparator<JsonNode>() {
			@Override
			public int compare(JsonNode jsonObjectA, JsonNode jsonObjectB) 
			{
			        int compare = 0;
			        try
			        {
			            String a = jsonObjectA.get("zip").textValue();
			            int keyA=Integer.parseInt(a);
			            String b = jsonObjectB.get("zip").textValue();
			            int keyB=Integer.parseInt(b);
			            compare = Integer.compare(keyA, keyB);
			        }
			        catch(Exception e)
			        {
			            
			        }
			        return compare;
			    }
			});
			
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), myJsonArrayAsList);
			
			System.out.println("Address Book is sorted by Zip...");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	private void sortByName()
	{
		JsonNode array;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			
			List<JsonNode> myJsonArrayAsList = new ArrayList<JsonNode>();
			for(JsonNode a:array)
			{
			    myJsonArrayAsList.add(a);
			}
			
			Collections.sort( myJsonArrayAsList, new Comparator<JsonNode>() 
			{
		        private static final String KEY_NAME = "firstName";

		        public int compare(JsonNode a, JsonNode b) 
		        {
		            String valA = new String();
		            String valB = new String();

		            try {
		                valA = a.get(KEY_NAME).toString();
		                valB = b.get(KEY_NAME).toString();
		            } 
		            catch (Exception e) 
		            {
		      
		            }
		            return valA.compareTo(valB);
		        }
		    });
			
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), myJsonArrayAsList);
			
			System.out.println("Address Book is sorted by First Name...");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
	}
	private void Delete()
	{
		JsonNode array;
		JsonNode object;
		String value1,value2;
		System.out.print("Enter First Name : ");
		String s1=s.next();
		System.out.println("\nEnter Last Name : ");
		String s2=s.next();
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			
			for(int i=0;i<array.size();i++)
			{
				object = array.get(i);	
				value1 = object.get("firstName").textValue();
				value2 = object.get("lastName").textValue();
				if(value1.equals(s1)&&value2.equals(s2))
				{
					ObjectNode objectNode = (ObjectNode) object;
					objectNode.put("firstName","");
					objectNode.put("lastName","");
					objectNode.put("state","");
					objectNode.put("city","");
					objectNode.put("address","");
					objectNode.put("zip","");
					objectNode.put("phoneNo","");
					
					ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
					writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), array);
					System.out.println("Record Delete...");
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
	private void Edit() 
	{
		System.out.print("Enter First Name : ");
		String s1=s.next();
		System.out.print("\nEnter Last Name : ");
		String s2=s.next();
		System.out.println("\nEnter New Contact : ");
		String s3=s.next();
		
		JsonNode array;
		JsonNode object;
		String value1,value2;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			
			for(int i=0;i<array.size();i++)
			{
				object = array.get(i);
				value1 = object.get("firstName").textValue();
				value2 = object.get("lastName").textValue();
				if(value1.equals(s1)&&value2.equals(s2))
				{
					ObjectNode objectNode = (ObjectNode) object;
					objectNode.put("phoneNo", s3);
					System.out.println(object);
				}
			}
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), array);
			
			System.out.println("\nContact is Updated...");
			
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"));
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	private void addUser()
	{
		Address ad=new Address();
	
		try
		{
			System.out.print("Enter your First Name : ");
			ad.setFirstName(s.next());
		
			System.out.print("Enter your Last Name : ");
			ad.setLastName(s.next());
		
			System.out.print("Enter your Address : ");
			ad.setAddress(s.next());
		
			System.out.print("Enter your State : ");
			ad.setState(s.next());
		
			System.out.print("Enter your City : ");
			ad.setCity(s.next());
		
			System.out.print("Enter your Zip : ");
			int i1=s.nextInt();
			ad.setZip(Integer.toString(i1));
		
			System.out.println("Enter your Phone No. : ");
			ad.setPhoneNo(s.next());
			
			List<Address> list=new ArrayList<Address>();
			try
			{
				list=objectMapper.readValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), new TypeReference<ArrayList<Address>>() {});
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			list.add(ad);
			System.out.println();
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/addressBook.json"), list);		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
