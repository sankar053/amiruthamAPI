/**
 * 
 */
package com.iii.amirutham.utills;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iii.amirutham.model.SequnceTable;
import com.iii.amirutham.service.SequenceService;

/**
 * @author sanka
 *
 */
public class AmirthumUtills {
	
	@Autowired
	private SequenceService seqservice;

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
