package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rest.SpringtestApplication;
import com.rest.domain.PageDTO;
import com.rest.domain.RestMenuDTO;
import com.rest.domain.RestUpdateFormVO;
import com.rest.domain.RestaurantMenuVO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;
import com.rest.exception.RestNotFoundException;
import com.rest.mapper.RestMapper;
import com.rest.mapper.ReviewMapper;
import com.rest.service.RestService;
import com.rest.service.ReviewService;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest 
@ContextConfiguration(classes = SpringtestApplication.class) 
@Slf4j
public class ReviewServiceTest {
	@Autowired
	private ReviewService service;
	@Autowired
	private ReviewMapper reviewMapper;
	
	
//	@Test
//	@DisplayName("리뷰 등록 테스트")
//	@Transactional
//	public void createReview() {
//		ReviewFormVO review = new ReviewFormVO(1L,"콘텐츠에오",2.3);
//		service.addReview(review);
//	}
//
//	@Test
//	@DisplayName("리뷰 삭제 테스트")
//	@Transactional
//	public void deleteReview() {
//		ReviewFormVO review = new ReviewFormVO(1L,"콘텐츠에오",2.3);
//		service.deleteReview(1L);
//	}
//	
	
	@Test
	@DisplayName("리뷰 조회 테스트")
	public void selectReviewAndMenus() {
		PageDTO dto = new PageDTO();
		dto.setLimit(10);
		dto.setOffset(1);
		dto.setRestId(1L);
		
		RestMenuDTO result = service.getRestReview(dto);
//		assertThat(result.getRest().getMenus().size()).isEqualTo(3);
//		assertThat(result.getRest().getReviews().size()).isEqualTo(6);
		System.out.println("gigigigigigi");
		log.info("result = {}",result);
		
	}
	
	
	
}
