/**
 * 
 */
package com.iii.amirutham.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;

/**
 * @author sanka
 *
 */
public interface CartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {
	
	 @Modifying
	  @Transactional
	  @Query("update cartitem u set u.isDeleted = :isDeleted where u.id = :id")
	  void updateIsDeletedStatus(@Param(value = "id") Integer id, @Param(value = "isDeleted") String isDeleted);
	

}
