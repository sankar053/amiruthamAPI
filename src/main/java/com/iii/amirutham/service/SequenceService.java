/**
 * 
 */
package com.iii.amirutham.service;

import com.iii.amirutham.dto.model.SequnceDto;

/**
 * @author sanka
 *
 */
public interface SequenceService {
	
	
	public SequnceDto findMySeQuence(String name);
	
	
	void updateMySeQuence(SequnceDto sequenceDto);

}
