/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iii.amirutham.model.TransactionDetails;

/**
 * @author admin
 *
 */
@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Integer> {

}
