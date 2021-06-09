/**
 * 
 */
package com.iii.amirutham.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.product.AmiruthamProducts;

/**
 * @author sanka
 *
 */
public interface ProductRepository extends JpaRepository<AmiruthamProducts, Integer> {
	
	
	  @Modifying
	  @Transactional
	  @Query(value ="update products p set p.PROD_RATING = :productRating,p.PROD_NOOF_REVIEWS=:noofreviews where p.id = :id", nativeQuery = true)
	  void updateProductRating(@Param(value = "id") Integer id, @Param(value = "productRating") float productRating,
			  @Param(value = "noofreviews") float noofreviews);
	
	  @Modifying
	  @Transactional
	  @Query(value ="update products p set p.deleted_yn = :active where p.id = :id", nativeQuery = true)
	  void updateactiveFlag(@Param(value = "id") Integer id, @Param(value = "active") String active);
	

}
