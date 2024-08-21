package com.rest.util;

import com.rest.domain.RestaurantMenuVO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
@Getter
@Setter
public class RestMenuResponse {
    private Long id;
    private String name;
    private String address;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    //menu와 연관관계
    private List<RestaurantMenuVO> menus;
}
