/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductVarient;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.repo.ProductVarientRepository;
import com.iii.amirutham.service.ProductVarientService;

/**
 * @author sanka
 *
 */
@Service
public class ProductVarientServiceImpl implements ProductVarientService {

	@Autowired
	private ProductVarientRepository productVarientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void addVarientInfo(ProductVarientDto productVarientDto) {
		
		Optional<AmiruthamProducts> product =productRepository.findById(productVarientDto.getProdid());
		if(product.isPresent()) {
			
			ProductVarient varientDao = new ProductVarient(productVarientDto.getMaximumRetailPrice(),
					productVarientDto.getDiscount(),
					productVarientDto.getUnit(),productVarientDto.getUnitType(),productVarientDto.getManufactureDate(),
					productVarientDto.getBestBeforeDate(),product.get(),product.get().getProductCode());
					productVarientRepository.save(varientDao);
		}
		
		// TODO Auto-generated method stub

	}

}
