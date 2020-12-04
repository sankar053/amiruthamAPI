/**
 * 
 */
package com.iii.amirutham.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sanka
 *
 */
@Entity(name = "PRODUCTS")
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmiruthamProducts extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "PROD_CODE")
	private String productCode;
	
	@Column(name = "PROD_NME")
	private String productNm;
	
	@Column(name = "PROD_DESC")
	private String productDesc;
	
	@Column(name = "PROD_BEN_USE")
	private String productuses;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy =
	 * "products") private Set<AmiruthamCategory> category = new HashSet<>();
	 */
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {
    		 CascadeType.ALL
        })
	@JoinColumn(name = "PROD_ID")
	private List<ProductMediaGallary> prodImgs;

	public AmiruthamProducts(Integer id, String productCode, String productNm, String productDesc, String productuses) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
		this.productuses = productuses;
	}




}
