package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.User;
import com.iii.amirutham.model.UserLocation;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
