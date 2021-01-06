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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
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
	
	@Column(name = "CATE_BANNER_URL")
	private String bannerImgUrl;
	
	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "bannerFileName")
	private String bannerFileNm;
	
	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "bannerFilepth")
	private String bannerFilepth;
	
	@Column(name = "bannerFileType")
	private String bannerImgType;

	
	@Column(name = "bannerFileSize")
	private Long bannerImgSize;
	
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
