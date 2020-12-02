package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.product.AmiruthamCategory;

public interface CategoryRepository extends JpaRepository<AmiruthamCategory, Integer> {

}
