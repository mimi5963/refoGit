package com.rest.domain;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonFilter("RestFilter")
public class RestaurantVO {
	private Long id;
	private String name;
	private String address;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	//menu와 연관관계 
	private List<RestaurantMenuVO> menus;
	
	//review와 연관관계
	private List<ReviewVO> reviews;
	


}
