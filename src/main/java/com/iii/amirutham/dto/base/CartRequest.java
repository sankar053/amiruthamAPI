/**
 * 
 */
package com.iii.amirutham.dto.base;

import java.util.List;

import com.iii.amirutham.dto.model.CategoryRequestItems;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class CartRequest {
	
	private Integer cartid;
	List<CategoryRequestItems> cartItems;

}
