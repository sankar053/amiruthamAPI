/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.shoppingcart.ShoppingCart;

/**
 * @author sanka
 *
 */
public interface CartRepository extends JpaRepository<ShoppingCart, Integer> {
	
	  List<ShoppingCart> findByCustomerId(Integer consumerId);
	
	

}
