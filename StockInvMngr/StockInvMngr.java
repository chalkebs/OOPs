package com.bridgelab.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockInvMngr 
{
	public static void main(String[]args)
	{
		 JSONParser jsonParser = new JSONParser();
         JSONArray array=new  JSONArray();
         JSONObject object=new  JSONObject();
	        
         try 
	        {
	            //Read JSON file
	            object = (JSONObject) jsonParser.parse(new FileReader("/home/admin28/eclipse-workspace/BridgelabzJavaCode/src/file3.json"));
	            ArrayList<Integer> a=new ArrayList<Integer>();
	            
	            System.out.println("Name\tNumOfShares\tSharePrice\tValue");
	            
	            array = (JSONArray)object.get("Share1");
	            System.out.print("Share1\t");
	            a.add((int) inventoryFactory(array));
	            System.out.println();
	            
	            array = (JSONArray)object.get("Share2");
	    		System.out.print("Share2\t");
	    		a.add((int) inventoryFactory(array));
	    		System.out.println();
	    		
	            array = (JSONArray)object.get("Share3");
	    		System.out.print("Share3\t");
	    		a.add((int) inventoryFactory(array));
	    		System.out.println();
	    		
	    		int sum=0;
	    		for(int i=0;i<a.size();i++)
	    			sum=sum+a.get(i);
	    			
	    		System.out.println("\nTotal value :"+sum);
	  
	        } catch (FileNotFoundException e) 
         	{
	            e.printStackTrace();
	        } catch (IOException e) 
         	{
	            e.printStackTrace();
	        } catch (Exception e) 
         	{
	        	e.printStackTrace();
	        }
	 }
	
	 public static long inventoryFactory(JSONArray array)
	    {
		 	Iterator<?> iterator = array.iterator();	//	iterator to iterate
		 	long numOfShare = 0;
		 	long price = 0;
		 	while(iterator.hasNext()) 
		 	{
		 		JSONObject obj = (JSONObject)iterator.next();
		 		numOfShare = (long)obj.get("NumOfShares");
		 		price = (long)obj.get("Price");
		 		System.out.print("\t"+numOfShare+"\t  "+price+"\t         "+numOfShare * price);
		 	}
		 	return (int)numOfShare*price;
	    }
}
