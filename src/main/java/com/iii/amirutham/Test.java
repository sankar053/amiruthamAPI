package com.iii.amirutham;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iii.amirutham.dto.model.UserDto;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set role =new HashSet<String>();
		role.add("sankar");
		UserDto user = new UserDto("Sankar","nara","","","",null,role);
		 ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(jsonString);

	}

}
