
  package com.iii.amirutham.repo;
  
  import java.util.UUID;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.iii.amirutham.model.User;
 
 
 
  public interface UserRepository extends JpaRepository<User, UUID> {
  
  }
 