package com.bridgelab.oops;
import com.bridgelab.oops.Details;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBook
{
	
	Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{
		AddressBook ab=new AddressBook();
		ab.choiceOfUser();
	}
	void choiceOfUser() throws FileNotFoundException, IOException, ParseException
	{
		System.out.print("1. Add\n2. Edit\n3. Delete\n4. Sort by Name\n5. Sort by Zip\n6. Print Entries\n7."
				+ " Quit\n");
		System.out.println("Enter Your Choice...");
		int choice=s.nextInt();
		JSONParser jsonParser = new JSONParser();
		JSONObject object=(JSONObject) jsonParser.parse(new FileReader("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file3.json"));
		JSONArray j=(JSONArray)object.get("User Details");
		
		switch(choice)
		{
			case 1: addUser();
					System.out.println("\n");
					choiceOfUser();
					break;
			case 2:
					System.out.print("Enter first and last name of the person to edit the contact: ");
					Extended(choice,j);
					System.out.println("\n");
					choiceOfUser();
					break;
			case 3:
					System.out.print("Enter first and last name of the person to delete the contact: ");
					Extended(choice,j);
					System.out.println("\n");
					choiceOfUser();
					break;
			case 4:
					System.out.print("Enter first and last name of the person to search: ");
					Extended(choice,j);
					System.out.println("\n");
					choiceOfUser();
					break;
			default:
					break;
		}
					
	}
	private void addUser() 
	{
		System.out.print("Enter your First Name : ");
		String fn=s.next();
		System.out.print("\nEnter your Last Name : ");
		String ln=s.next();
		System.out.print("\nEnter your Address : ");
		s.nextLine();
		String addr=s.nextLine();
		System.out.print("\nEnter your City : ");
		String city=s.next();
		System.out.print("\nEnter your State : ");
		String state=s.next();
		System.out.print("\nEnter your Zip Code : ");
		String zip=s.next();
		System.out.print("\nEnter your Phone Number : ");
		String pn=s.next();
		
		Details d=new Details(fn,ln,addr,city,state,zip,pn);
		JSONArray jsonArray = d.toJsonObject();
		System.out.print(jsonArray);
		writeBook(jsonArray);
	}
	
	
	@SuppressWarnings("unchecked")
	void writeBook(JSONArray jsonArray) 
	{
		JSONArray book = null;

		File file = new File("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/addressBook.json");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			book = new JSONArray();
		} else {
			try 
			{
				book = new JSONArray();
			    book.add(jsonArray);
				BufferedWriter b=new BufferedWriter(new FileWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/addressBook.json"));
				b.write(jsonArray.toJSONString());
		        b.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		printWriter(book);

		System.out.println("Details added successfully");
	}
	
	void printWriter(JSONArray book) 
	{
		try {
			
			PrintWriter writer = new PrintWriter("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/addressBook.json");
			writer.write(book.toJSONString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void Extended(int choice,JSONArray j) 
	{
		String firstName = s.next();
		String lastName = s.next();

		
		Iterator<?> iterator = j.iterator();
		int i = 0;
		boolean b = false;
		outer:
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject)iterator.next();
			if (jsonObject.get("First Name").equals(firstName) && jsonObject.get("Last Name").equals(lastName)) {
				b = true;
				switch (choice) {
				case 2:
					edit(jsonObject, j, i);
					break outer;
				case 3:
					delete(j, i);
					break outer;
				case 4:
					search(jsonObject);
					break outer;
				}
			}
			i++;
		}
		if(!b) {
			System.out.println("user not found...");
		}
	}
	private void search(JSONObject jsonObject) 
	{
		System.out.println("Name:\n" + jsonObject.get("First Name") + " " + jsonObject.get("Last Name"));
		System.out.println("Address:\n" + jsonObject.get("Address"));
		System.out.print(jsonObject.get("City") + ", ");
		System.out.print(jsonObject.get("State") + " - ");
		System.out.println(jsonObject.get("Zip"));
		System.out.println("Phone Number:\n" + jsonObject.get("Phone Number"));
	}
	private void delete(JSONArray bookArray, int i) 
	{
		bookArray.remove(i);
		
		printWriter(bookArray);
		System.out.println("Details deleted successfully");
	}

	@SuppressWarnings("unchecked")
	private void edit(JSONObject jsonObject, JSONArray bookArray, int i) 
	{
		System.out.println("What do you want to edit?");
		System.out.println("1. Address");
		System.out.println("2. Phone Number");
		
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			System.out.print("Enter address: ");
			s.nextLine();
			
			String address = s.nextLine();
			System.out.print("Enter city, state and zip: ");
			String city = s.next();
			String state = s.next();
			String zip = s.next();
			
			jsonObject.put("Address", address);
			jsonObject.put("City", city);
			jsonObject.put("State", state);
			jsonObject.put("Zip", zip);
			break;

		case 2:
			System.out.println("Enter phone number: ");
			String phoneNumber = s.next();
			jsonObject.put("Phone Number", phoneNumber);
			break;
		}
		
		bookArray.remove(i);
		bookArray.add(i, jsonObject);
		
		printWriter(bookArray);
		System.out.println("Details updated successfully");
	}
}
