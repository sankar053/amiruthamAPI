
  package com.iii.amirutham.repo;
  
  import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.User;
 
 
 
  public interface UserRepository extends JpaRepository<User, Integer> {
	  
	  Optional<User> findByPhoneNbr(String username);

		Boolean existsByPhoneNbr(String username);

		Boolean existsByEmailAddress(String email);
  
  }
 