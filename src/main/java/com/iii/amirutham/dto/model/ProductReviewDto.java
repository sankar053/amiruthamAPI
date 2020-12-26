package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDto {

	private Integer id;

	private Integer reviewParentId;

	private Integer reviewRating;

	private String reviewComments;
	
	private Integer poroductId;

	private User user;

	private AmiruthamProducts product;

	public ProductReviewDto(Integer reviewParentId, @NotEmpty @NotNull Integer reviewRating, String reviewComments,
			@NotEmpty @NotNull Integer poroductId) {
		super();
		this.reviewParentId = reviewParentId;
		this.reviewRating = reviewRating;
		this.reviewComments = reviewComments;
		this.poroductId = poroductId;
	}


	

}
