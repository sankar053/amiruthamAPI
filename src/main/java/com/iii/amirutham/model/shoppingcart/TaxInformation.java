/**
 * 
 */
package com.iii.amirutham.model.shoppingcart;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "cartTax")
@Table(name = "cartTax")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TaxAmount", nullable = false)
	private BigDecimal finalTaxAmount=new BigDecimal(0.00);
	
	@Column(name = "taxPresentage", nullable = false) 
	private Double totalTaxPresentage;
	
	@Column(name = "sgstPresentage", nullable = false)
	private Double sgstPresentage;
	
	@Column(name = "sgst", nullable = false)
	private BigDecimal sgst;
	
	@Column(name = "cgstPresentage", nullable = false)
	private Double cgstPresentage;
	
	@Column(name = "cgst", nullable = false)
	private BigDecimal cgst;

	@Column(name = "description", nullable = false) // TODO CODE
	private String description;

	public TaxInformation(BigDecimal finalTaxAmount, Double totalTaxPresentage, Double sgstPresentage,
			BigDecimal sgst, Double cgstPresentage, BigDecimal cgst, String description) {
		super();
		this.finalTaxAmount = finalTaxAmount;
		this.totalTaxPresentage = totalTaxPresentage;
		this.sgstPresentage = sgstPresentage;
		this.sgst = sgst;
		this.cgstPresentage = cgstPresentage;
		this.cgst = cgst;
		this.description = description;
	}

	




	

}
