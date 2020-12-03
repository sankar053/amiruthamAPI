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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
@Data
public class AmiruthamCategory extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String categoryCd;
	
	private String categoryNm;
	
	private String categoryDesc;
	
	@ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.ALL
	            })
	    @JoinTable(name = "category_product",
	            joinColumns = { @JoinColumn(name = "category_id") },
	            inverseJoinColumns = { @JoinColumn(name = "product_id") })
		private Set<AmiruthamProducts> products =new HashSet<AmiruthamProducts>();

	public AmiruthamCategory(String categoryCd, String categoryNm,
			String categoryDesc) {
		super();
		this.categoryCd = categoryCd;
		this.categoryNm = categoryNm;
		this.categoryDesc = categoryDesc;
	
	}

	public AmiruthamCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
