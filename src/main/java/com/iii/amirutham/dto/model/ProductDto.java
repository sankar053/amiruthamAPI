/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sanka
 *
 */
@Data
public class ProductDto {
	

	private Integer id;
	
	private String productCode;
		
	private String productNm;
	
	private String productDesc;
	
   
}
