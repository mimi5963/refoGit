package com.rest.mapper;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.rest.domain.PageDTO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;

@Mapper
public interface ReviewMapper {

	void insertReview(ReviewFormVO review);

	void deleteReview(Long reviewId);
	
	Float selectAvgScore(Long restId);
	
	Optional<RestaurantVO> selectRestAndReview(PageDTO param);
	
	

}
