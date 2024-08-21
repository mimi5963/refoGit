package com.rest.service;

import com.rest.domain.PageDTO;
import com.rest.domain.RestMenuDTO;
import com.rest.domain.ReviewFormVO;

public interface ReviewService {

	void addReview(ReviewFormVO review);

	void deleteReview(Long reviewId);
	
	public RestMenuDTO getRestReview(PageDTO page);

}
