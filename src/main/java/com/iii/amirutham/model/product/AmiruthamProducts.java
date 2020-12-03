/**
 * 
 */
package com.iii.amirutham.model.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;
import com.iii.amirutham.model.UserAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmiruthamProducts extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String productCode;
		
	private String productNm;
	
	private String productDesc;
	
    @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.ALL
	            },
	            mappedBy = "products")
	    private Set<AmiruthamCategory> category = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {
    		 CascadeType.ALL
        })
	@JoinColumn(name = "PROD_ID")
	private List<ProductMediaGallary> prodImgs;

	public AmiruthamProducts(Integer id, String productCode, String productNm, String productDesc,
			List<ProductMediaGallary> prodImgs) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
		this.prodImgs = prodImgs;
	}

	public AmiruthamProducts(String productCode, String productNm, String productDesc) {
		super();
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
	}

	
	public AmiruthamProducts(Integer id,String productCode, String productNm, String productDesc) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
	}

    

}
