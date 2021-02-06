package com.iii.amirutham.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.HomeBanner;
import com.iii.amirutham.model.HomeBannerMedia;
import com.iii.amirutham.model.product.CategoryBanner;
import com.iii.amirutham.model.product.ProductMediaGallary;

public interface BannerRepository extends JpaRepository<HomeBanner, Integer> {
	
	@Transactional
	@Modifying
	@Query("delete from homebannermedia m where m.id=:id")
	void deleteSelectedHomeBannerImg(@Param("id") Integer id);
	
	@Query("select m from homebannermedia m where m.id=:id")
	HomeBannerMedia getSelectedHomeBannerImg(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from ProductMediaGallary m where m.id=:id")
	void deleteProductImage(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from CategoryBanner m where m.id=:id")
	void deleteCategoryBanner(@Param("id") Integer id);
	
	@Query("select c from CategoryBanner c where c.id=:id")
	CategoryBanner getSelectedCategoryBannerImg(@Param("id") Integer id);
	
	@Query("select p from ProductMediaGallary p where p.id=:id")
	ProductMediaGallary getSelectedProductBannerImg(@Param("id") Integer id);
	
	
	HomeBanner findByIsActive(String activeYN);
	
//	@Query("select * from categoryBanner m where m.id=:id")
//	HomeBannerMedia getHomeBanner(@Param("id") Integer id);

}
