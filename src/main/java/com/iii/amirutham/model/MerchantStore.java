/**
 * 
 */
package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "company")
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantStore extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String companyName;
	
	@NotEmpty
	@Column(name = "COMPANY_CODE", nullable = false, unique = true, length = 100)
	private String code;
	
	private String firstName;
	
	private String LastName;
	
	@NotEmpty
	@Column(name = "COMPANY_PHONE", length = 50)
	private String companyphone;
	
	@Email
	@NotEmpty
	@Column(name = "COMPANY_EMAIL", length = 60, nullable = false)
	private String companyEmailAddress;

	@JsonIgnore
	@Column(name = "COMPANY_LOGO", length = 100)
	private String companyLogo;
	
	@Column(name = "COMPANY_ADDRESS")
	private String companyaddress;
	
	@NotEmpty
	@Column(name = "COMPANY_CITY", length = 100)
	private String companycity;
	
	@NotEmpty
	@Column(name = "COMPANY_POSTAL_CODE", length = 15)
	private String companypostalcode;

	@NotEmpty
	@Column(name = "COMPANY_COUNTRY", length = 15)
	private String companyCountry;

	
	

}
