/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.product.AmiruthamProducts;

/**
 * @author sanka
 *
 */
public interface ProductRepository extends JpaRepository<AmiruthamProducts, Integer> {

}
