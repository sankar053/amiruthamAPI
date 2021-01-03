/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Orders, Integer> {

	List<Orders> findByUser(User user,Pageable pageable);

}
