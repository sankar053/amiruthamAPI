/**
 * 
 */
package com.iii.amirutham.common.report.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class InvoiceMerchentData {

	private Integer id;
	
	
	private String companyName ;
	
	private String companySubName ;
	
	private String CompanyCode;

	private String companyEmailAddress;

	
	private String companyLogo;
	
	private String companyAddressLine1;
	
	private String companyAddressLine2;
	
	private String companyAddressLine3;
	
	private String companyCity;
	
	private String companyPostalCode;
	
	private String companyPhone;
	
	private String companygstNo;

	public InvoiceMerchentData() {
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
