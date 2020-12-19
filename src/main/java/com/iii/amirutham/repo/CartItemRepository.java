/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;

/**
 * @author sanka
 *
 */
public interface CartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

}
