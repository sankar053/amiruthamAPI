package com.iii.amirutham.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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
	@Column(name = "bannerCode")
	private String bannerCode;

	@Size(min = 2, message = "Banner Name Should not Null")
	@NotBlank
	@NotNull
	@Column(name = "bannerName")
	private String bannerName;

	@Size(min = 2, message = "Banenr Description Should have Atleast two character")
	@NotBlank
	@NotNull
	@Column(name = "bannerDesc")
	private String bannerDesc;

		
	@Column(name = "home_insta_link")
	private String instaLink;
	
	@Column(name = "home_youtube_link")
	private String youtubeLink;
	
	@Column(name = "home_facebook_link")
	private String facebookLink;
	
	@Column(name = "home_whatsapp_link")
	private String whatsappLink;
	

	@OneToMany(mappedBy = "home", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HomeBannerMedia> bannerImgs;
	
	

}
