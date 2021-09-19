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

import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

	public List<Address> findByUser(User customer);
	
	 @Modifying
	  @Transactional
	  @Query("update address u set u.isDeleted = :isDeleted where u.id = :id")
	  void updateDeleteFlag(@Param(value = "id") Integer id, @Param(value = "isDeleted") String isDeleted);
	  
}
