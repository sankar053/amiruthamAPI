package com.iii.amirutham.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.model.HomeBanner;
import com.iii.amirutham.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@PostMapping
	public ResponseEntity<Object> createHomeBanner(@RequestPart("payload") String payload,
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
		bannerService.addHomeBanner(payload, file);

		return new ResponseEntity("Banner Added Successfully", HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<Object> retribeAllBanner() {
		List<HomeBanner> bannerList = bannerService.retriveAllBanners();

		return new ResponseEntity(bannerList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> retribeBannerByID(@PathVariable int id) {
		Optional<HomeBanner> banner = bannerService.retribeBannerByID(id);

		return new ResponseEntity(banner.get(), HttpStatus.OK);

	}

}
