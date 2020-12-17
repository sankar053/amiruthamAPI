/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.MerchantStore;

/**
 * @author sanka
 *
 */
public interface SellerRepository extends JpaRepository<MerchantStore, Integer> {

}
