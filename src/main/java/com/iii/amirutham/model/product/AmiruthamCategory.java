/**
 * 
 */
package com.iii.amirutham.model.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "AMIR_PROD_CATEGORY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmiruthamCategory extends BaseEntity {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CATE_CODE",unique=true, nullable=false)
	private String categoryCd;
	
	@Column(name = "CATE_NME")
	private String categoryNm;
	
	@Column(name = "CATE_DESC")
	private String categoryDesc;
	
	@Column(name = "CATE_ORDER",unique=true, nullable=false)
	private Integer categoryOrder;
	
	@JsonIgnore 
	@OneToMany(mappedBy="category")
	private Set<AmiruthamProducts> products =new HashSet<AmiruthamProducts>();

	
	  public AmiruthamCategory(Integer id, String categoryCd, String categoryNm, String categoryDesc, Integer categoryOrder) {
			super();
			this.id = id;
			this.categoryCd = categoryCd;
			this.categoryNm = categoryNm;
			this.categoryDesc = categoryDesc;
			this.categoryOrder = categoryOrder;
		}

	
	

}
