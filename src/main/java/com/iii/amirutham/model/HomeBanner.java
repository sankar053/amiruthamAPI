package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "homebanner")
@Table(name = "homebanner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeBanner extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@Column(name = "bannerName")
	private String bannerName;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "bannerDesc")
	private String bannerDesc;

	@Size(min = 2, message = "LastName Should have Atleast two character")
	@Column(name = "bannerFileName")
	private String bannerFileNm;
	
	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "bannerFilepth")
	private String bannerFilepth;
	
	@Size(min = 2, message = "LastName Should have Atleast two character")
	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "bannerFileUrl")
	private String bannerImgUrl;
	
	@Column(name = "bannerFileType")
	private String bannerImgType;

	
	@Column(name = "bannerFileSize")
	private Long bannerImgSize;

}
