package com.bridgelab.oops;

import com.bridgelab.oops.Patient;
import com.bridgelab.oops.Doctor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonInclude(Include.NON_NULL)
public class CliniqueManagement 
{
	ObjectMapper objectMapper = new ObjectMapper();
		
	Scanner s=new Scanner(System.in);
	public static void main(String[] args)
	{
		CliniqueManagement ab=new CliniqueManagement();
		ab.choiceOfUser();
	}
	void choiceOfUser()
	{
		char ch = 0;
		do 
		{
			System.out.print("\n1. Add Patient\n2. Add Doctor\n3. Take Appointment\n4. Print Report\n5."
						+ " Quit\n");
			System.out.println("\nEnter Your Choice...");
			int choice=s.nextInt();
				
			switch(choice)
			{
				case 1: 
						addPatient();
						break;
				case 2:
						addDoctor();
						break;
				case 3:
						takeAppointment();
						break;
				case 4:
						printReport();
						break;
				default:
						System.out.println("\n Invalid Input...");
				}
				System.out.println("\nIf you want to continue then enter y...");
				ch=s.next().charAt(0);
				
			}while(ch=='y'||ch=='Y');	
	}
	
	void addPatient() 
	{
		Patient p=new Patient();
		JsonNode doctorArray;
		try
		{
			doctorArray = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/doctor.json"));
			System.out.print("\nEnter your Full Name : ");
			p.setName(s.next()+" "+s.next()+" "+s.next());
			
			ArrayList<Integer> l = new ArrayList<Integer>();
		    for (int i=1; i<=(doctorArray.size()*5); i++) 
		    {
		    	l.add(new Integer(i));
		    }
		    Collections.shuffle(l);
		    for (int i=1; i<(doctorArray.size()*5); i++) 
		    {
		    	String id=String.valueOf(l.get(i));
		    	p.setID(id);
		    }
		
			System.out.print("Enter your Mobile No. : ");
			p.setMobileNo(s.next());
		
			System.out.print("Enter your Age : ");
			p.setAge(s.next());
			
			List<Patient> list=new ArrayList<Patient>();
			try
			{
				list=objectMapper.readValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/patient.json"), new TypeReference<ArrayList<Patient>>() {});
			}
			catch(Exception e)
			{
				
			}
			list.add(p);
			System.out.println();
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/patient.json"), list);
		}
		catch(Exception e)
		{
			
		}
	}
	void addDoctor()
	{
		Doctor d=new Doctor();
		
		try
		{
			System.out.print("\nEnter your Full Name : ");
			d.setName(s.next()+" "+s.next()+" "+s.next());
		
			System.out.print("\nEnter your ID No.  : ");
			int a1=s.nextInt();
			d.setID(String.valueOf(a1));
		
			System.out.print("\nEnter your Specialization : ");
			d.setSpecialization(s.next());
		
			System.out.print("\nEnter your Availability Time From (Note: Enter Time only in 24 Hrs Format) : ");
			int a2=s.nextInt();
			d.setAvailabilityFrom(String.valueOf(a2));
			
			System.out.print("\nEnter your Availability Time To (Note: Enter Time only in 24 Hrs Format) : ");
			int a3=s.nextInt();
			d.setAvailabilityTo(String.valueOf(a3));
			
			List<Doctor> list=new ArrayList<Doctor>();
			try
			{
				list=objectMapper.readValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/doctor.json"), new TypeReference<ArrayList<Doctor>>() {});
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			list.add(d);
			System.out.println();
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/doctor.json"), list);		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	JsonNode array1,object1;
	ArrayList<String> v11=new ArrayList<String>();
	void count()
	{
		Count co=new Count();
		
		try 
		{
			array1 = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/appointment.json"));
			
			for(int i=0;i<array1.size();i++)
			{
				object1 = array1.get(i);	
				v11.add(object1.get("nameDR").textValue());
			}
			System.out.println(v11);
			int j=0;
			co.setNameDR(v11.get(j));
			co.setCount(String.valueOf(Collections.frequency(v11, v11.get(j))));
			j++;
			outer:
			if(j<v11.size())
			{
				co.setNameDR(v11.get(j));
				co.setCount(String.valueOf(Collections.frequency(v11, v11.get(j))));
				j++;
				break outer;
			}
				
	        List<Count> l2=new ArrayList<Count>();
			
			l2=objectMapper.readValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/count.json"), new TypeReference<ArrayList<Count>>() {});
			
			l2.add(co);
			System.out.println();
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/count.json"), l2);	
		} 
		catch (Exception e1) 
		{
			
		}
	}
	void takeAppointment() 
	{
		Appointment ap=new Appointment();
		
		count();
		
		JsonNode array,object;
		String v1,v2,v3,v4;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/doctor.json"));
			
			System.out.println("\nDoctors Are : ");
			for(int i=0;i<array.size();i++)
			{
				object = array.get(i);	
				v1 = object.get("name").textValue();
				v2 = object.get("specialization").textValue();
				v3 = object.get("availabilityFrom").textValue();
				v4 = object.get("availabilityTo").textValue();
				System.out.print("\nName of DOCTOR : "+v1+"\nSpecialization : "+v2+"\nAvailability From : "+v3+" AM\n"
						+ "Availability To : "+v4+" PM\n");
			}
			
			System.out.println("\nEnter Doctor's Full Name for Appointment :");
			ap.setNameDR(s.next()+" "+s.next()+" "+s.next());
			System.out.println("\nEnter Patient's Full Name :");
			ap.setNamePt(s.next()+" "+s.next()+" "+s.next());
			
			List<Appointment> list=new ArrayList<Appointment>();
			
			list=objectMapper.readValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/appointment.json"), new TypeReference<ArrayList<Appointment>>() {});
			
			list.add(ap);
			System.out.println();
			ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("/home/admin28/eclipse-workspace/JacksonSample/src/appointment.json"), list);	
		}
		catch(Exception e)
		{
			System.out.println("\n No doctor is available...");
		}
	}
	void printReport() 
	{
		JsonNode array;
		try 
		{
			array = objectMapper.readTree(new File("/home/admin28/eclipse-workspace/JacksonSample/src/appointment.json"));
			String i = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(array);
			System.out.println(i);
		}
		catch(Exception e)
		{
			
		}
	}
}
