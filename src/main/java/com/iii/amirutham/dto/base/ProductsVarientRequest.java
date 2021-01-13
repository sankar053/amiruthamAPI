/**
 * 
 */
package com.iii.amirutham.dto.base;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.iii.amirutham.dto.model.ProductVarientDto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class ProductsVarientRequest {
	
	
	@NotNull
	private Integer prodid;

	@Valid
	@NotNull
	List<ProductVarientDto> varientList;
}
