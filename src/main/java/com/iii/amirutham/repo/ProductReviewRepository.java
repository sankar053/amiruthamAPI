/**
 * 
 */
package com.iii.amirutham.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductReviews;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface ProductReviewRepository extends PagingAndSortingRepository<ProductReviews, Integer> {

	Page<ProductReviews> findByProduct(AmiruthamProducts product, Pageable pageable);

	
	@Query("select c from ProductReviews c")
	Page<ProductReviews> findAllPage(Pageable pageable);

	@Query("select c from ProductReviews c")
	Slice<ProductReviews> findAllSlice(Pageable pageable);

	@Query("select c from ProductReviews c")
	List<ProductReviews> findAllSorted(Sort sort);

	Page<ProductReviews> findByUser(User user, Pageable pageable);

	@Query("select c from ProductReviews c where c.createdTs = :createdTs")
	Slice<ProductReviews> findByMovieCustom(@Param("createdTs") String createdTs, Pageable pageable);

	@Query("select c from ProductReviews c where c.createdTs = :createdTs")
	List<ProductReviews> findByMovieSorted(@Param("createdTs") String createdTs, Sort sort);

}
