package com.rest.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rest.domain.PageDTO;
import com.rest.domain.RestMenuDTO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;
import com.rest.exception.RestNotFoundException;
import com.rest.mapper.RestMapper;
import com.rest.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;

	@Override
	public void addReview(ReviewFormVO review) {
		// TODO Auto-generated method stub
		reviewMapper.insertReview(review);
	}

	@Override
	public void deleteReview(Long reviewId) {
		reviewMapper.deleteReview(reviewId);
		
	}
	@Override
	public RestMenuDTO getRestReview(PageDTO page) {
		
		RestMenuDTO result = new RestMenuDTO();
		result.setPage(page);
		result.setAvgScore(reviewMapper.selectAvgScore(page.getRestId()));
		Optional<RestaurantVO> findRest = reviewMapper.selectRestAndReview(page);
		
		if(findRest.isPresent()) {
			result.setRest(findRest.get());
		}
		else {
			log.info("예외발생");
			throw new RestNotFoundException("해당 레스토랑이 존재하지 않거나, 리뷰가 더 이상 존재하지 않습니다.");
		}
		return result;
	}
	
}
