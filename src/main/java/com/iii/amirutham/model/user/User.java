package com.iii.amirutham.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.iii.amirutham.model.BaseEntity;
import com.iii.amirutham.model.Address;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "All Details about User")
@Entity(name = "User")
@Table(name = "AMIR_USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@Column(name = "AMIR_USER_FST_NM")
	private String firstName;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "AMIR_USER_LST_NM")
	private String lastName;

	@Size(min = 10, message = "LastName Should have Atleast two character")
	@Column(name = "AMIR_USER_PHN_NBR")
	private String phoneNbr;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "AMIR_USER_MAIL_ADDR")
	private String emailAddress;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "AMIR_USER_PWD",length = 60)
	private String password;

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "AMIR_USER_ID")
	private List<Address> address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

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
