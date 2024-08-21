package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.rest.mapper.RestMapper;
import com.rest.service.RestServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = SpringtestApplicationTests.class)
class SpringtestApplicationTests {
	@Autowired
	private RestServiceImpl service;
	@Autowired
	private RestMapper restMapper;
	
	@Test
	public void restTest1() {
		
		assertThat(service.hi()).isEqualTo("hi");
	}

}
