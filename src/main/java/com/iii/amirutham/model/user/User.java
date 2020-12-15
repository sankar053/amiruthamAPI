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

import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "All Details about User")
@Entity(name = "user")
@Table(name = "user")
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
	@Column(name = "firstName")
	private String firstName;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "lastName")
	private String lastName;

	@Size(min = 10, message = "LastName Should have Atleast two character")
	@Column(name = "phoneNumber")
	private String phoneNbr;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "emailAddress")
	private String emailAddress;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "password",length = 60)
	private String password;

	
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "userId")
	private List<Address> address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "userrole", 
				joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
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
