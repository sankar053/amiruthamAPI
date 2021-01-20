/**
 * 
 */
package com.iii.amirutham.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.BaseEntity;
import com.iii.amirutham.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "PRODUCT_REVIEWS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviews extends BaseEntity


{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REV_ID")
	private Integer id;
	
	@Column(name = "REV_PARENT_ID")
	private Integer reviewParentId;
	
	@Column(name = "REV_RATING")
	private Integer reviewRating;
	
	@Column(name = "REV_COMMENTS")
	private String reviewComments;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="prod_id", nullable=false)
    private AmiruthamProducts product;

	public ProductReviews(Integer reviewParentId, Integer reviewRating, String reviewComments) {
		super();
		this.reviewParentId = reviewParentId;
		this.reviewRating = reviewRating;
		this.reviewComments = reviewComments;
	}
	
	

}

