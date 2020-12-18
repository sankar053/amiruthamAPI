package com.iii.amirutham.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
		HomeBanner bannerDao=bannerService.addHomeBanner(payload, file);

		return  ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
               .body(bannerDao);

	}

	@GetMapping
	public ResponseEntity<Object> retribeAllBanner() {
		List<HomeBanner> bannerList = bannerService.retriveAllBanners();

		return ResponseEntity.ok() .contentType(MediaType.APPLICATION_JSON)
	               .body(bannerList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> retribeBannerByID(@PathVariable int id) {
		Optional<HomeBanner> banner = bannerService.retribeBannerByID(id);

		return ResponseEntity.ok() .contentType(MediaType.APPLICATION_JSON)
	               .body(banner.get());

	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = bannerService.loadBannerAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
