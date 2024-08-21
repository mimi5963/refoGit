package com.rest.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestaurantMenuVO {
	private Long id;
	private Long restaurantId;
	private Integer price;
	private String name;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public RestaurantMenuVO(Integer price, String name) {
		this.price = price;
		this.name = name;
	}
}
