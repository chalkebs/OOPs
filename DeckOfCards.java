package com.bridgelab.oops;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckOfCards 
{
	public static void main(String[] args)
	{
		String[][] suit= {{"Clubs","Diamonds", "Hearts", "Spades"},
				{"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}};
		
		random(suit);
	}

	private static void random(String[][] suit) 
	{
		Random rn=new Random();
		ArrayList<String> l=new ArrayList<String>();
		
		for(int j=0;j<13;j++)
		{
			for(int i=0;i<4;i++)
			{
				l.add(suit[0][i]+" "+suit[1][j]);
			}
		}
		
		for (int i = 0; i < l.size(); i++) 
        { 
            int r = i + rn.nextInt(52 - i); 
              
            Collections.swap(l, i, r);           
        } 
		
        int s=0;
        for (int i=0; i<4; i++) 
        {
        	System.out.println("Player no. "+(i+1));
        	System.out.print("-------------\n");
        	for(int j=0;j<9;j++)
        	{	
        		System.out.println(l.get(s));
        		s++;
        	}
        	System.out.println();
        }
	}
}
