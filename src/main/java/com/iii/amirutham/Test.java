package com.iii.amirutham;

import java.util.HashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  Scanner sc = new Scanner(System.in);
			      String scInp = sc.nextLine();
			  	String [] input = scInp.split(","); 
			  Integer WdAmt = Integer.valueOf(input[0]);
			  String [] denomi = input[1].split(",");
			  HashMap<Integer,Integer> dinominator = new HashMap<Integer,Integer>();
			  Integer available=0;
			  for(String d : denomi)
			  {
			    String [] sind = d.split("==>");
			      dinominator.put(Integer.valueOf(sind[0]),Integer.valueOf(sind[1]));
			    available =available+(Integer.valueOf(sind[0])*Integer.valueOf(sind[1]));
			  }
			  
		
	}

}
