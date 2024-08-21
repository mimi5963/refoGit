package com.rest.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.domain.RestInsertFormVO;
import com.rest.domain.RestUpdateFormVO;
import com.rest.util.RestMenuResponse;
import com.rest.domain.RestaurantVO;
import com.rest.service.RestService;
import com.rest.util.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestService restService;

    @GetMapping("/restaurants")
    public CommonResponse<List<RestaurantVO>> getAllRest() throws JsonProcessingException {
        List<RestaurantVO> restList = restService.getRestList();
        SimpleFilterProvider filter = new SimpleFilterProvider().addFilter("RestFilter", SimpleBeanPropertyFilter.serializeAllExcept("reviews", "menus"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilterProvider(filter);
        String filterJson = mapper.writeValueAsString(restList);
        List list = mapper.readValue(filterJson, List.class);
        return CommonResponse.<List<RestaurantVO>>setSuccess(list, HttpStatus.OK.value());
    }


    @GetMapping("/restaurant/{restaurantId}")
    public CommonResponse<RestMenuResponse> getRestWithMenu(@PathVariable Long restaurantId) throws JsonProcessingException {
        RestaurantVO rest = restService.getRest(restaurantId);

        // 필터 설정
        SimpleFilterProvider filter = new SimpleFilterProvider()
                .addFilter("RestFilter", SimpleBeanPropertyFilter.serializeAllExcept("reviews"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilterProvider(filter);

        // 필터링된 객체 생성
        String filteredJson = mapper.writeValueAsString(rest);
        RestMenuResponse filteredRest = mapper.readValue(filteredJson, RestMenuResponse.class);


        return CommonResponse.<RestMenuResponse>setSuccess(filteredRest,HttpStatus.OK.value());
    }

    @PostMapping("/restaurant")
    public CommonResponse<String> createRest(@Valid @RequestBody RestInsertFormVO insertRest, BindingResult br){

        restService.createRest(insertRest);
        return CommonResponse.<String>setSuccess("맛집을 성공적으로 등록했습니다.",HttpStatus.OK.value());
    }

    @PutMapping("/restaurant/{restaurantId}")
    public CommonResponse<String> updateRest(@PathVariable Long restaurantId,  @Valid @RequestBody RestUpdateFormVO updateRest, BindingResult br){
        updateRest.setId(restaurantId);
        restService.updateRest(updateRest);
        return CommonResponse.<String>setSuccess("맛집을 성공적으로 수정했습니다.",HttpStatus.OK.value());
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public CommonResponse<String> deleteRest(@PathVariable Long restaurantId){
        restService.removeRest(restaurantId);
        return CommonResponse.<String>setSuccess("맛집을 성공적으로 삭제했습니다.",HttpStatus.OK.value());
    }
}

