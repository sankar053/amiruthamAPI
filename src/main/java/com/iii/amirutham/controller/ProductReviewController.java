/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.ProductReviewDto;
import com.iii.amirutham.model.product.ProductReviews;
import com.iii.amirutham.repo.ProductReviewRepository;
import com.iii.amirutham.service.ProductReviewService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/product/review")
public class ProductReviewController {
	

	@Autowired
	private MessageSource messages;
	
	@Autowired
	private ProductReviewRepository reviewRepo;
	
	@Autowired
	private ProductReviewService revivewService;
	
	@PostMapping
	public  @ResponseBody ResponseEntity<GenericResponse> addReviews(HttpServletRequest request,@Valid @RequestBody ProductReviewDto reviewRequest) {
		
		revivewService.addReviewsToProduct(reviewRequest);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("message.product.review.success", null, request.getLocale())));
		
	}
	
	@GetMapping(value = {"/{productId}"})
	public  @ResponseBody ResponseEntity<Page<ProductReviews>> getReviewsByProduct(HttpServletRequest request,@PathVariable Integer productId,@RequestParam(name = "page",required = false) Integer pageNo, 
			@RequestParam(name = "size",required = false) Integer pageSize,@Qualifier("amirthum") Pageable pageable) {
		
		Page<ProductReviews> reviews = revivewService.getReviewsByProduct(productId,pageNo, pageSize,pageable);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(reviews);
		
	}
	
	@GetMapping(path = "/page")
	List<ProductReviews> loadCharactersPage(
			@PageableDefault(page = 0, size = 5)
			@SortDefault.SortDefaults({
					@SortDefault(sort = "createdTs", direction = Sort.Direction.ASC),
					@SortDefault(sort = "id", direction = Sort.Direction.ASC)
			})
		Pageable pageable) {
		return reviewRepo.findAllPage(pageable).toList();
	}

	
	@GetMapping(path = "/sorted")
	List<ProductReviews> loadCharactersSorted(Sort sort) {
		return reviewRepo.findAllSorted(sort);
	}

	@GetMapping(path = "/slice")
	Slice<ProductReviews> loadCharactersSlice(Pageable pageable) {
		return reviewRepo.findAllSlice(pageable);
	}

}
