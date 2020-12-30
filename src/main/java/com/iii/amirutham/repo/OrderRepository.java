/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.order.Order;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUser(User user);

}
