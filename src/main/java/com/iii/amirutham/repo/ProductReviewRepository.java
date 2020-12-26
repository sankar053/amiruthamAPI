/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductReviews;

/**
 * @author sanka
 *
 */
public interface ProductReviewRepository extends JpaRepository<ProductReviews, Integer> {
	
	  List<ProductReviews> findByProduct(AmiruthamProducts product);

}
