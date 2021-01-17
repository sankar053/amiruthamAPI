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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.service.CategoryService;
import com.iii.amirutham.utills.AmirthumUtills;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MessageSource messages;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<GenericResponse> saveCategory(HttpServletRequest request,
			@RequestPart("payload") String payload, @RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {

		CategoryDto categoryDto = (CategoryDto) AmirthumUtills.convertJsontoObject(CategoryDto.class, payload);
		AmiruthamCategory categoryDao;
		if (categoryDto.getId() == 0) {
			categoryDao = categoryService.createCategory(categoryDto, files);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("category.message.create.success", null, request.getLocale()), categoryDao));
		} else {
			categoryDao = categoryService.updateCategory(categoryDto, files);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("category.message.update.success", null, request.getLocale()), categoryDao));

		}

	}

	@PostMapping("/Multiple")
	public ResponseEntity<GenericResponse> saveBulkCategory(HttpServletRequest request,
			@RequestPart("payload") String payload, @RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {
		CategoryRequest categoryRequest = (CategoryRequest) AmirthumUtills.convertJsontoObject(CategoryRequest.class,
				payload);
		categoryService.createBulkCategory(categoryRequest, files);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse("success"));

	}

	@PutMapping
	public ResponseEntity<Object> updateCategory(HttpServletRequest request, @Valid @RequestBody CategoryDto categories,
			@Valid @NotNull @NotBlank List<MultipartFile> files) {

		AmiruthamCategory updatedCategory = categoryService.updateCategory(categories, files);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(updatedCategory);

	}

	@PatchMapping
	public ResponseEntity<Object> updateCategoryPatch(HttpServletRequest request,
			@Valid @RequestBody CategoryDto categories, @Valid @NotNull @NotBlank List<MultipartFile> files) {

		AmiruthamCategory updatedCategory = categoryService.updateCategory(categories, files);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(updatedCategory);

	}

	@GetMapping
	public ResponseEntity<Object> getAllCatogry() {
		List<CategoryDto> catogList = categoryService.findAllCatogry();
		System.out.println(catogList.size());
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(catogList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCatogryById(@PathVariable int id) {
		CategoryDto category = categoryService.findCatogryById(id);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(category);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCatogryById(HttpServletRequest request,@PathVariable int id) {
		categoryService.deleteCatogry(id);
		List<CategoryDto> catogList = categoryService.findAllCatogry();
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
				messages.getMessage("category.message.delete.success", null, request.getLocale()), catogList));
		

	}

	@GetMapping("/downloadFile/{fileName:.+}/{catCode}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, @PathVariable String catCode,
			HttpServletRequest request) {
		// Load file as Resource
		Resource resource = categoryService.loadBannerAsResource(fileName, catCode);

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

	@PostMapping("/bulk")
	public ResponseEntity<GenericResponse> saveBulkCategory(
			@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile files) {

		categoryService.createBulkCategory(files);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse("success"));

	}

}
