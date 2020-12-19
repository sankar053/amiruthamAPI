/**
 * 
 */
package com.iii.amirutham.dto.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class CategoryRequestItems {
	
	private Integer quantity;

	private Integer varientId;

	private Integer productId;
	
	private String itemUpdateStatus;
	
	private Integer itemId;

}
