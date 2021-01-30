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
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
public class MerchantStore extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "COMPANY_NAME", length = 60, nullable = false)
	private String companyName ;
	
	@Column(name = "COMPANY_SUB_NAME", length = 60, nullable = false)
	private String companySubName ;
	
	@NotEmpty
	@Column(name = "COMPANY_CODE", nullable = false, unique = false, length = 100)
	private String CompanyCode;

	
	@Column(name = "COMPANY_EMAIL", length = 60, nullable = false)
	private String companyEmailAddress;

	@JsonIgnore
	@Column(name = "COMPANY_LOGO", length = 100)
	private String companyLogo;
	
	@Column(name = "COMPANY_ADDRESS1")
	private String companyAddressLine1;
	
	@Column(name = "COMPANY_ADDRESS2")
	private String companyAddressLine2;
	
	@Column(name = "COMPANY_ADDRESS3")
	private String companyAddressLine3;
	
	@Column(name = "COMPANY_CITY", length = 100)
	private String companyCity;
	
	@Column(name = "COMPANY_POSTAL_CODE", length = 15)
	private String companyPostalCode;
	
	@Column(name = "COMPANY_PHONE", length = 50)
	private String companyPhone;
	
	@Column(name = "COMPANY_GST_NO", length = 50)
	private String companygstNo;

	public MerchantStore() {
		super();
		this.companyName = "SVS TRADING COMPANY";
		this.companySubName = "COLD PRESS OIL SHOP";
		CompanyCode = "C0001";
		this.companyEmailAddress = "";
		this.companyLogo = "";
		this.companyAddressLine1 = "44/1,SHANTHINIKETAN COLONY";
		this.companyAddressLine2 = "THIRUMANGALAM,ANNA NAGAR WEST EXTIN";
		this.companyAddressLine3 = "";
		this.companyCity = "CHENNAI";
		this.companyPostalCode = "101";
		this.companyPhone = "044-43370022";
		this.companygstNo = "33ADFFS826661ZU";
	}


	

}
