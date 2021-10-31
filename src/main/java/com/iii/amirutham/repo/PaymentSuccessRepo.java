/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iii.amirutham.model.PaymentSuccess;

/**
 * @author admin
 *
 */
@Repository
public interface PaymentSuccessRepo extends JpaRepository<PaymentSuccess, Integer> {

}
