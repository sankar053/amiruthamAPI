package com.iii.amirutham.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties(value = { "dateMajTech", "dateCreaTech" })
public class BaseEntity {

	/**
	 * Update date
	 */
	@Column(name = "UPDATE_TS", insertable = false, updatable = true)
	private Timestamp dateMajTech;

	@Column(name = "CREATION_TS", insertable = true, updatable = false)
	private Timestamp dateCreaTech;

	@Column(name = "CREATED_BY", insertable = true, updatable = false)
	private String createdBy;

	@Column(name = "UPDATED_BY", insertable = true, updatable = false)
	private String updatedBy;

	@Column(name = "ACTIVE_YN", insertable = true, updatable = false)
	private String isActive;

	@Column(name = "DELETED_YN", insertable = true, updatable = false)
	private String isDeleted;

	@PrePersist
	void onCreate() {
		this.setDateCreaTech(new Timestamp((new Date()).getTime()));
		this.setIsActive("Y");
		this.setIsDeleted("N");
		this.setCreatedBy("Amirthum");
		this.setUpdatedBy("Amirthum");
	}

	@PreUpdate
	void onPersist() {
		this.setDateMajTech(new Timestamp((new Date()).getTime()));
	}

}
