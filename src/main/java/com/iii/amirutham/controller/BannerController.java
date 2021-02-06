
package com.iii.amirutham.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.BannerDto;
import com.iii.amirutham.dto.model.CustomerNewsLetterDto;
import com.iii.amirutham.service.BannerService;
import com.iii.amirutham.utills.AmirthumUtills;


@RestController
@RequestMapping("/home")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@Autowired
	private MessageSource messages;

	@PostMapping("/banner")
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<GenericResponse> createHomeBanner(HttpServletRequest request,
			@RequestPart("payload") String payload,
			@RequestPart(name = "file",required=false) List<MultipartFile> files) {

		BannerDto bannerdto = (BannerDto) AmirthumUtills.convertJsontoObject(BannerDto.class, payload);
		if (bannerdto.getId() == 0) {
			bannerService.addHomeBanner(bannerdto, files);
			List<BannerDto> homeBanners = bannerService.retriveAllBanners();
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("banner.message.create.success", null, request.getLocale()), homeBanners));
		} else {
			bannerService.updateHomeBanner(bannerdto, files);
			List<BannerDto> homeBanners = bannerService.retriveAllBanners();
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("banner.message.update.success", null, request.getLocale()), homeBanners));
		}

	}

	@GetMapping("/banner")
	public ResponseEntity<BannerDto> retribeAllBanner() {
		BannerDto homeBanners = bannerService.retriveActiveBanner();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
				.body(homeBanners);

	}

	@GetMapping("/{id}")
	public ResponseEntity<BannerDto> retribeBannerByID(@PathVariable int id) {
		BannerDto homeBanner = bannerService.retribeBannerByID(id);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(homeBanner);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> deleteBannerByID(HttpServletRequest request, @PathVariable int id) {
		bannerService.deleteBannerByID(id);
		List<BannerDto> homeBanners = bannerService.retriveAllBanners();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
				messages.getMessage("banner.message.detete.success", null, request.getLocale()), homeBanners));

	}

	@GetMapping("banner/downloadFile/{fileName:.+}/{bannerCode}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, @PathVariable String bannerCode,
			HttpServletRequest request) {
		// Load file as Resource
		Resource resource = bannerService.loadBannerAsResource(fileName, bannerCode);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/emailFile/{fileName:.+}/{templateCode}")
	public ResponseEntity<Resource> downloadEmailTemplateFile(@PathVariable String fileName,
			@PathVariable String templateCode, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = bannerService.loadEmailTemplateResource(fileName, templateCode);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@PostMapping("/subscribe")
	public ResponseEntity<GenericResponse> createHomeBanner(HttpServletRequest request,
			@Valid @RequestBody CustomerNewsLetterDto requestContactus) {

		bannerService.addHomecontactreference(requestContactus);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(
				new GenericResponse(messages.getMessage("home.message.contactus.success", null, request.getLocale())));

	}

}
