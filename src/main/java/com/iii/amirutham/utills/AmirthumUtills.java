/**
 * 
 */
package com.iii.amirutham.utills;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

	public static <T> boolean IsNullOrEmpty(Collection<T> list) {
		return list == null || list.isEmpty();
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

	
	}
	
	public static String getDay() {
		DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
		return dayOfWeek.toString();
	}
	
	public static String timeStampFormat(Date date1) throws ParseException {
	
		DateFormat df2 = new SimpleDateFormat(Constant.DEFAULT_DATE_FORMAT);
		String end = df2.format(date1);
		date1 = df2.parse(end);
		
		SimpleDateFormat month_date = new SimpleDateFormat("MMM dd,yyyy");
		String monthName = month_date.format(date1.getTime());
		return monthName;
	}
	
	public static String htmlToXhtml(String html) {
	    Document document = Jsoup.parse(html);
	    document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
	    return document.html();
	}

}
