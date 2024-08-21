package com.rest.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestMenuDTO {
	private RestaurantVO rest;
	private PageDTO page;
	private Float avgScore;
}
