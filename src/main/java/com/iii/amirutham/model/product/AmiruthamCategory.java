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
	
	@Column(name = "CATE_CODE")
	private String categoryCd;
	
	@Column(name = "CATE_NME")
	private String categoryNm;
	
	@Column(name = "CATE_DESC")
	private String categoryDesc;
	
	@JsonIgnore 
	@OneToMany(mappedBy="category")
	private Set<AmiruthamProducts> products =new HashSet<AmiruthamProducts>();

	
	  public AmiruthamCategory(Integer id, String categoryCd, String categoryNm, String categoryDesc) {
			super();
			this.id = id;
			this.categoryCd = categoryCd;
			this.categoryNm = categoryNm;
			this.categoryDesc = categoryDesc;
		}

	
	

}
