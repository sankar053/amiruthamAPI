/**
 * 
 */
package com.iii.amirutham.utills;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sanka
 *
 */
public class AmirthumUtills {

	

	public static Object convertJsontoObject(Class c, String jsonStr) {

		try {
			ObjectMapper objMapper = new ObjectMapper();
			return objMapper.readValue(jsonStr, c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unused")
	public static Object convertToDto(Object conversionObject,Class c,ModelMapper modelMapper) {
		return modelMapper.map(conversionObject, c);
	
	}

	public static String generateOTP() {

		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}

	public static void makeaDirectory(Path path) {

		try {
			if (!Files.exists(path))
				Files.createDirectories(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * File directory = new File(String.valueOf(path));
		 * 
		 * if (!directory.exists()) directory.mkdir();
		 */
	}

}
