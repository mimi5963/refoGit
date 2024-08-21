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
public class ReviewVO {
	private Long id;
	private Long restaurantId;
	private String content;
	private Double score;
	private Timestamp createdAt;
}
