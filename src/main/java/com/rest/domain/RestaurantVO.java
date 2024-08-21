package com.rest.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	
	
	public RestaurantVO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void setMenuRestId() {
		this.menus.forEach((menu) -> {
			menu.setRestaurantId(this.id);
		});
	}
}
