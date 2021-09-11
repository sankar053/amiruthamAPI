/**
 * 
 */
package com.iii.amirutham.repo;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Orders, Integer> {

	Page<Orders> findByUser(User user,Pageable pageable);
	
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.orderStatus = :orderStatus where u.id = :id")
	  void updateOrderStatus(@Param(value = "id") Integer id, @Param(value = "orderStatus") OrderStatus orderStatus);
	  
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.orderStatus = :orderStatus, orderTrackingUrl= :orderTrackingUrl where u.id = :id")
	  void updateOrderStatus(@Param(value = "id") Integer id, @Param(value = "orderStatus") OrderStatus orderStatus,
			  @Param(value = "orderTrackingUrl") String orderTrackingUrl);
	

}
