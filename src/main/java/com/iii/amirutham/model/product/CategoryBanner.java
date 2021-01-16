/**
 * 
 */
package com.iii.amirutham.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name = "CATEGORY_BANNER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBanner extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "bannerFileName")
	private String bannerFileNm;

	@Column(name = "bannerFilepth")
	private String bannerFilepth;

	@Column(name = "bannerFileUrl")
	private String bannerImgUrl;

	@Column(name = "bannerFileType")
	private String bannerImgType;

	@Column(name = "bannerFileSize")
	private Long bannerImgSize;
//	//@JsonIgnore
	@ManyToOne(targetEntity = AmiruthamCategory.class)
	@JoinColumn(name = "category_id", nullable = true)
	private AmiruthamCategory categorymedia;

	public CategoryBanner(String bannerFileNm, String bannerFilepth, String bannerImgUrl, String bannerImgType,
			Long bannerImgSize,AmiruthamCategory category) {
		super();
		this.bannerFileNm = bannerFileNm;
		this.bannerFilepth = bannerFilepth;
		this.bannerImgUrl = bannerImgUrl;
		this.bannerImgType = bannerImgType;
		this.bannerImgSize = bannerImgSize;
		this.categorymedia=category;
	}

}
