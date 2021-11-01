/**
 * 
 */
package com.iii.amirutham.repo;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.order.PaymentType;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Orders, Integer> {

	Page<Orders> findByUser(User user,Pageable pageable);
	//Page<Orders> findALL(Pageable pageable);
	
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.orderStatus = :orderStatus where u.id = :id")
	  void updateOrderStatus(@Param(value = "id") Integer id, @Param(value = "orderStatus") OrderStatus orderStatus);
	  
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.paymentType = :paymentType, transactionRefNo = :transactionRefNo,paymentOn=:paymentOn  where u.id = :id")
	  void updateOrderTransStatus(@Param(value = "id") Integer id, @Param(value = "paymentType") PaymentType paymentType,String transactionRefNo, LocalDateTime paymentOn );
	  
	  
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.orderStatus = :orderStatus, orderTrackingUrl= :orderTrackingUrl where u.id = :id")
	  void updateOrderStatus(@Param(value = "id") Integer id, @Param(value = "orderStatus") OrderStatus orderStatus,
			  @Param(value = "orderTrackingUrl") String orderTrackingUrl);
	  
	  
	  Optional<Orders> findByRazorPayOrderReference(String razorOrderRef);
	  
	  Optional<Orders> findByRazorPayTransReference(String razorPaymentRef);
	  
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.razorPayTransReference = :razorPayTransReference, u.orderPaymentStatus= 'PAID', u.paymentOn=:paymentOn where u.id = :id and u.razorPayOrderReference=:razorPayOrderReference")
	  void updateOrderPaymentStatus( @Param(value = "razorPayTransReference") String razorPayTransReference,@Param(value = "paymentOn") LocalDateTime paymentOn,
			  @Param(value = "id") Integer id,@Param(value = "razorPayOrderReference") String razorPayOrderReference);
	  
	  @Modifying
	  @Transactional
	  @Query("update orders u set u.razorPayRefundReference = :razorPayRefundReference, u.orderPaymentStatus= 'REFUNDED', u.refundOn=:refundOn where u.id = :id and u.razorPayTransReference=:razorPayTransReference")
	  void updateOrderRefundStatus( @Param(value = "razorPayRefundReference") String razorPayRefundReference,@Param(value = "refundOn") LocalDateTime refundOn,
			  @Param(value = "razorPayTransReference") String razorPayTransReference,@Param(value = "id") Integer id);
	  
	
	  
}
