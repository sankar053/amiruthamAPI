/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.shoppingcart.ShoppingCart;

/**
 * @author sanka
 *
 */
public interface CartRepository extends JpaRepository<ShoppingCart, Integer> {
	
	  List<ShoppingCart> findByCustomerId(Integer consumerId);
	  
	
	  @Modifying
	  @Transactional
	  @Query("update cart u set u.shoppingCartStatus = :shoppingCartStatus where u.id = :id")
	  void updateShoppingCartStatus(@Param(value = "id") Integer id, @Param(value = "shoppingCartStatus") String shoppingCartStatus);
	
	

}
