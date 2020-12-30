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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "PRODUCTS")
@Table(name = "PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmiruthamProducts extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "PROD_CODE")
	private String productCode;
	
	@Column(name = "PROD_BRAND")
	private String productBrand;
	
	@Column(name = "PROD_CAT_CODE",unique=true, nullable=false)
	private String productCategoryCode;
	
	@Column(name = "PROD_NME")
	private String productNm;
	
	@Column(name = "PROD_DESC",columnDefinition="LONGTEXT")
	private String productDesc;
	
	@Column(name = "PROD_BEN_USE",columnDefinition="LONGTEXT")
	private String productuses;
	
	@Column(name = "PROD_SPEC_DTLS",columnDefinition="LONGTEXT")
	private String productspec;
	
	@Column(name = "PROD_incredience_DTLS",columnDefinition="LONGTEXT")
	private String productincredience;
	
	@Column(name = "PROD_HIGHLIGHT")
	private String productHighlight;
	
	@Column(name = "PROD_BEST_SELLING_YN")
	private String productBestSellingYN="N";
	
	
	@Column(name = "PROD_AVAILABLE")
	private boolean available = true;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private AmiruthamCategory category;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = {
    		 CascadeType.ALL
        })
	@JoinColumn(name = "PROD_ID")
	private List<ProductMediaGallary> prodImgs;
    
   // @JsonIgnore 
	@OneToMany(mappedBy="product")
	private List<ProductVarient> prodVarient;

	public AmiruthamProducts(Integer id, String productCode, String productNm, String productDesc, String productuses,Integer stock,String productincredience) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
		this.productuses = productuses;
		this.productincredience=productincredience;
	}




}
