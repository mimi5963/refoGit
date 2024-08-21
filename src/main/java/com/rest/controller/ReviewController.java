package com.rest.controller;

import com.rest.domain.RestMenuDTO;
import com.rest.domain.ReviewFormVO;
import com.rest.service.ReviewService;
import com.rest.util.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public CommonResponse<String> createReview(@Valid @RequestBody ReviewFormVO reviewFormVO, BindingResult br){
        reviewService.addReview(reviewFormVO);
        return CommonResponse.<String>setSuccess("리뷰를 성공적으로 등록했습니다.", HttpStatus.OK.value());
    }

    @DeleteMapping("/review/{reviewId}")
    public CommonResponse<String> deleteReview(@PathVariable Long reviewId ){
        reviewService.deleteReview(reviewId);
        return CommonResponse.<String>setSuccess("리뷰를 성공적으로 삭제했습니다.", HttpStatus.OK.value());
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public CommonResponse<RestMenuDTO> getAllRestReview(@PathVariable Long restaurantId){
        return null;
    }
}
