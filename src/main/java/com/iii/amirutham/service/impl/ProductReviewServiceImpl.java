/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.ProductReviewDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.INProductAvgRating;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductReviews;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.repo.ProductReviewRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.ProductReviewService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@Service
public class ProductReviewServiceImpl implements ProductReviewService {

	@Autowired
	private ProductReviewRepository reviewRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	// @Autowired

	@Autowired
	private ProductRepository prodRepository;

	@Override
	public void addReviewsToProduct(@Valid ProductReviewDto reviewRequest) {
		// TODO Auto-generated method stub
		UserDetailsImpl userdetails = userService.getUserDetails();

		ProductReviews reviewDao = new ProductReviews(reviewRequest.getReviewParentId(),
				reviewRequest.getReviewRating(), reviewRequest.getReviewComments());

		Optional<User> user = userRepository.findById(userdetails.getId());
		if (user.isPresent())
			reviewDao.setUser(user.get());
		Optional<AmiruthamProducts> prodct = prodRepository.findById(reviewRequest.getPoroductId());
		if (prodct.isPresent()) {
			reviewDao.setProduct(prodct.get());
			reviewRepo.save(reviewDao);
			updateProductRating(prodct.get().getId());
		} else {
			throw new UserNotFoundException("Please select the valid product");
		}

	}

	private void updateProductRating(Integer prodId) {
		// TODO Auto-generated method stub
		INProductAvgRating ProductAvgRating = reviewRepo.findRatingByCategoryId(prodId);
		prodRepository.updateProductRating(prodId, ProductAvgRating.getRating(),ProductAvgRating.getTotalReviews());
	}

	@Override
	public Page<ProductReviews> getReviewsByProduct(Integer productId, Integer pageNo, Integer pageSize,
			Pageable pageable) {
		// TODO Auto-generated method stub
		if (pageNo != null && pageSize != null)
			pageable = PageRequest.of(pageNo, pageSize);
		Optional<AmiruthamProducts> prodct = prodRepository.findById(productId);

		if (prodct.isPresent())
			return reviewRepo.findByProduct(prodct.get(), pageable);
		return null;

	}

}
