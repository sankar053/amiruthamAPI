/**
 * 
 */
package com.iii.amirutham.model.product;

import java.util.HashSet;
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

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "AMIR_PROD_CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmiruthamCategory extends BaseEntity {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CATE_CODE")
	private String categoryCd;
	
	@Column(name = "CATE_NME")
	private String categoryNm;
	
	@Column(name = "CATE_DESC")
	private String categoryDesc;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable(name = "category_product", joinColumns = { @JoinColumn(name =
	 * "category_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	 */
	  @OneToMany(fetch = FetchType.EAGER, cascade = {
	    		 CascadeType.ALL
	        })
	@JoinColumn(name = "CATE_ID")
	private Set<AmiruthamProducts> products =new HashSet<AmiruthamProducts>();

	
	  public AmiruthamCategory(Integer id, String categoryCd, String categoryNm, String categoryDesc) {
			super();
			this.id = id;
			this.categoryCd = categoryCd;
			this.categoryNm = categoryNm;
			this.categoryDesc = categoryDesc;
		}

	
	

}
