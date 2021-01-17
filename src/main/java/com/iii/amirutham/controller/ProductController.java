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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.service.ProductService;
import com.iii.amirutham.utills.AmirthumUtills;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private MessageSource messages;

	@PostMapping
	public ResponseEntity<Object> saveProducts(HttpServletRequest request, @RequestPart("payload") String payload,
			@RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {
		
		ProductDto productsDto = (ProductDto) AmirthumUtills.convertJsontoObject(ProductDto.class, payload);
		if (productsDto.getId() != 0) {
			AmiruthamProducts product = productService.updateProductandMedia(productsDto,files,request);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("product.message.update.success", null, request.getLocale())));
		} else {
			AmiruthamProducts product =productService.addProductandMedia(productsDto, files, request);
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
					messages.getMessage("product.message.create.success", null, request.getLocale())));
		}

	
	}

	@GetMapping
	public ResponseEntity<Object> retriveProducts() {
		List<ProductDto> productList = productService.retriveProducts();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> retriveProducts(@PathVariable int id) {
		ProductDto product = productService.retriveProductById(id);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(product);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(HttpServletRequest request, @PathVariable int id) {

		productService.deleteProductById(id);

		List<ProductDto> productList = productService.retriveProducts();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(
				messages.getMessage("category.message.delete.success", null, request.getLocale()), productList));
	}

	@GetMapping("/downloadFile/{fileName:.+}/{catCode}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, @PathVariable String catCode,
			HttpServletRequest request) {
		// Load file as Resource
		Resource resource = productService.loadProductAsResource(fileName, catCode);

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

}
