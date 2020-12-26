/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import javax.validation.Valid;

import com.iii.amirutham.dto.model.ProductReviewDto;
import com.iii.amirutham.model.product.ProductReviews;

/**
 * @author sanka
 *
 */
public interface ProductReviewService {

	void addReviewsToProduct(@Valid ProductReviewDto reviewRequest);

	List<ProductReviews> getReviewsByProduct(Integer productId);

}
