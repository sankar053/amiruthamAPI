/**
 * 
 */
package com.iii.amirutham.model.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
public class AmiruthamProducts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String productCode;
		
	private String productNm;
	
	private String productDesc;
	
    @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	            mappedBy = "products")
	    private Set<AmiruthamCategory> category = new HashSet<>();

	public AmiruthamProducts(String productCode, String productNm, String productDesc) {
		super();
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
	}
    
    
    

}
