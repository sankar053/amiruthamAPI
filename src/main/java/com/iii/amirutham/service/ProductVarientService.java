/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.iii.amirutham.dto.base.ProductsVarientRequest;
import com.iii.amirutham.model.product.ProductVarient;

/**
 * @author sanka
 *
 */
public interface ProductVarientService {
	
	public void addVarientInfo(ProductsVarientRequest productVarientRequest);

	public void updateVarientInfo(@Valid ProductsVarientRequest productVarientRequest);

	public void deleteVarientInfoById(String id);

	public void deleteVarientInfo();

	Optional<ProductVarient>  getVarientInfoById(String id);

	List<ProductVarient>  getAllVarientInfo();

}
