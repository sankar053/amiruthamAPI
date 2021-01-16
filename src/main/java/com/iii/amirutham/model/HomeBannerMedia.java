/**
 * 
 */
package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "homebannermedia")
@Table(name = "homebannermedia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeBannerMedia extends BaseEntity {

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
	@JsonIgnore
	@ManyToOne(targetEntity = HomeBanner.class)
	@JoinColumn(name = "HOME_ID", nullable = true)
	private HomeBanner home;

	public HomeBannerMedia(String bannerFileNm, String bannerFilepth, String bannerImgUrl, String bannerImgType,
			Long bannerImgSize,HomeBanner home) {
		super();
		this.bannerFileNm = bannerFileNm;
		this.bannerFilepth = bannerFilepth;
		this.bannerImgUrl = bannerImgUrl;
		this.bannerImgType = bannerImgType;
		this.bannerImgSize = bannerImgSize;
		this.home=home;
	}

}
