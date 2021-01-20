/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.CustomerNewsLetter;

/**
 * @author sanka
 *
 */
public interface NewsLetterRepository extends JpaRepository<CustomerNewsLetter, Integer> {

}
