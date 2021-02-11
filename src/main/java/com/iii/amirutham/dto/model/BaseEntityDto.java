/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class BaseEntityDto {
	
	
	private Timestamp updatedTs;

	private Timestamp createdTs;

	private String createdBy;

	private String updatedBy;

	//@JsonIgnore
	private String isActive;

	@JsonIgnore
	private String isDeleted;

	
}
