package com.iii.amirutham.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "All Details about User")
@Entity
@Data
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@ApiModelProperty(notes = "FirstName Should have Atleast two character")
	private String firstName;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String lastName;

	@Size(min = 10, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String phoneNbr;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String emailAddress;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "USER_ID")
	private List<UserAddress> address;

	/*
	 * public User(Integer id, String firstName,String lastName) { super(); this.id
	 * = id; this.firstName = firstName; //this.birthDate = birthDate;
	 * this.lastName= lastName; }
	 * 
	 * public User() {
	 * 
	 * }
	 */

}
