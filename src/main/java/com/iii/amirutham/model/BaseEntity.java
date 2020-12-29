package com.iii.amirutham.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties(value = { "createdTs", "updatedTs" })
public class BaseEntity {

	/**
	 * Update date
	 */
	@JsonIgnore
	@Column(name = "UPDATE_TS", insertable = false, updatable = true)
	private Timestamp updatedTs;

	@JsonIgnore
	@Column(name = "CREATION_TS", insertable = true, updatable = false)
	private Timestamp createdTs;

	@JsonIgnore
	@Column(name = "CREATED_BY", insertable = true, updatable = false)
	private String createdBy;

	@JsonIgnore
	@Column(name = "UPDATED_BY", insertable = true, updatable = false)
	private String updatedBy;

	@JsonIgnore
	@Column(name = "ACTIVE_YN", insertable = true, updatable = false)
	private String isActive;

	@JsonIgnore
	@Column(name = "DELETED_YN", insertable = true, updatable = false)
	private String isDeleted;

	@PrePersist
	void onCreate() {
		this.setCreatedTs(new Timestamp((new Date()).getTime()));
		this.setIsActive("Y");
		this.setIsDeleted("N");
		this.setCreatedBy("Amirthum");
	
	}

	@PreUpdate
	void onPersist() {
		this.setUpdatedTs(new Timestamp((new Date()).getTime()));
		this.setUpdatedBy("Amirthum");
	}

}
