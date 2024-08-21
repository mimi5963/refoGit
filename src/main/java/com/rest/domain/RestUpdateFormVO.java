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
public class RestUpdateFormVO {
	
	private Long id;
	private String name;
	private String address;
	
	//menu와 연관관계 
	private List<RestaurantMenuVO> menus;
	
	public RestUpdateFormVO(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public void setMenuRestId() {
		this.menus.forEach((menu) -> {
			menu.setRestaurantId(this.id);
		});
	}
}
