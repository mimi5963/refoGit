package com.rest.service;

import java.util.List;

import com.rest.domain.RestUpdateFormVO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;

public interface RestService {
	public String hi();
	
	List<RestaurantVO> getRestList();
	RestaurantVO getRest(Integer id);

	public void createRest(RestaurantVO rest);

	public void updateRest(RestUpdateFormVO rest);

	public void removeRest(long restId);

	public void createReview(ReviewFormVO review);
	
}
