
  package com.iii.amirutham.repo;
  
  import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.user.User;
 
 
 
  public interface UserRepository extends JpaRepository<User, Integer> {
	  
	  Optional<User> findByPhoneNbr(String username);
	  Optional<User> findByEmailAddress(String username);

		Boolean existsByPhoneNbr(String username);

		Boolean existsByEmailAddress(String email);
  
  }
 