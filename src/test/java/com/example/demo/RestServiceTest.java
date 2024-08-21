package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rest.SpringtestApplication;
import com.rest.domain.RestUpdateFormVO;
import com.rest.domain.RestaurantMenuVO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;
import com.rest.exception.RestNotFoundException;
import com.rest.mapper.RestMapper;
import com.rest.service.RestService;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest 
@ContextConfiguration(classes = SpringtestApplication.class) 
@Slf4j
public class RestServiceTest {
	@Autowired
	private RestService service;
	@Autowired
	private RestMapper restMapper;
	
	
	
	
	  @Test public void restTest1() {
	  
	  assertThat(service.hi()).isEqualTo("hi"); }
	  
	  @Test
	  
	  @DisplayName("모든 레스토랑 정보 가져오는 테스트") public void allRestTest() {
	  List<RestaurantVO> lists = service.getRestList();
	  assertThat(lists.size()).isEqualTo(3);
	  
	  assertThat(lists.get(0).getName()).isEqualTo("t1");
	  assertThat(lists.get(1).getName()).isEqualTo("t2");
	  assertThat(lists.get(2).getName()).isEqualTo("t3");
	  
	  log.info(lists.get(0).getCreatedAt()+"시간");
	  
	  }
	  
	  @Test
	  @DisplayName("특정 레스토랑의 모든 정보 가져오는 테스트") public void restDetailTest() { //DB에 있는 레스토랑의 ID를 입력한 경우 
	  RestaurantVO findRest = service.getRest(1);
	  assertThat(findRest.getMenus().size()).isEqualTo(3);
	  assertThat(findRest.getReviews().size()).isEqualTo(3);
	  log.info("레스토랑 정보 = {}",findRest);
	  
	  }
	 
	
	@Test
	@DisplayName("없는 레스토랑의 모든 가져올 때 Exception 테스트")
	public void restDetailTest2() {
		  //DB에 없는 레스토랑 ID를 입력한 경우 -> RestNotFoundException 
		  assertThatThrownBy(()->{
		  service.getRest(100); }).isExactlyInstanceOf(RestNotFoundException.class).hasMessage("해당 레스토랑은 존재하지 않습니다.");
		 
	}
	
	@Test
	@DisplayName("맛집-메뉴 엮는 테스트")
	public void setMenuRestTest() {
		RestaurantVO rest = new RestaurantVO("야탑","동작구");
		rest.setId(200L);
		rest.setMenus(new ArrayList<>());
		rest.getMenus().add(new RestaurantMenuVO(1000,"뭘까"));
		rest.getMenus().add(new RestaurantMenuVO(1000,"나는"));
		
		rest.setMenuRestId();
		
		rest.getMenus().forEach((m) -> assertThat(m.getRestaurantId()).isEqualTo(200));
		
	}
	
	@Test
	@DisplayName("맛집 생성 테스트")
	@Transactional
	public void createRestTest2() {
		RestaurantVO rest = new RestaurantVO("야탑","동작구");
		rest.setMenus(new ArrayList<>());
		rest.getMenus().add(new RestaurantMenuVO(1000,"뭘까"));
		rest.getMenus().add(new RestaurantMenuVO(1000,"나는"));
		rest.setMenuRestId();
		service.createRest(rest);
			
	}
	
	@Test
	@DisplayName("맛집 업데이트 테스트")
	@Transactional
	public void updateRest() {

		RestUpdateFormVO rest =  new RestUpdateFormVO("야탑","동작구");
		rest.setId(1L);
		rest.setMenus(new ArrayList<>());
		rest.getMenus().add(new RestaurantMenuVO(1000,"뭘까"));
		rest.getMenus().add(new RestaurantMenuVO(1000,"나는"));
		
		service.updateRest(rest);
	}
	
	@Test
	@DisplayName("맛집 삭제 테스트")
	@Transactional
	public void deleteRest() {
		//삭제완료
		service.removeRest(1L);
	}
	
	
	
	
	
}
