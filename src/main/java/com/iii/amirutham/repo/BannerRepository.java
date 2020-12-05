package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.HomeBanner;

public interface BannerRepository extends JpaRepository<HomeBanner, Integer> {

}
