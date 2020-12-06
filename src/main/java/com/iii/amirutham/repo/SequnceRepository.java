/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.SequnceTable;

/**
 * @author sanka
 *
 */
public interface SequnceRepository extends JpaRepository<SequnceTable, Integer> {
	
	 Optional<SequnceTable> findBySeqName(String seqNm);

}
