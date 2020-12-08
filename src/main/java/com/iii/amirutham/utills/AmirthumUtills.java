/**
 * 
 */
package com.iii.amirutham.utills;

import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sanka
 *
 */
public class AmirthumUtills {
	
	

	public  static Object convertJsontoObject(Class c, String jsonStr) {

		try {
			ObjectMapper objMapper = new ObjectMapper();
			return objMapper.readValue(jsonStr, c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	 public static String generateOTP(){
		 
		Random random = new Random();	
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	 }
	

}
