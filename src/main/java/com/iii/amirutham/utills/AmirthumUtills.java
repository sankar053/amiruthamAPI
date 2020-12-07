/**
 * 
 */
package com.iii.amirutham.utills;

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
	
	

}
