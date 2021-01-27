/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

	public List<Address> findByUser(User customer);
}
