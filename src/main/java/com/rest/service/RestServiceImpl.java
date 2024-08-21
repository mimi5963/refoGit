package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.domain.RestUpdateFormVO;
import com.rest.domain.RestaurantMenuVO;
import com.rest.domain.RestaurantVO;
import com.rest.domain.ReviewFormVO;
import com.rest.exception.RestNotFoundException;
import com.rest.mapper.RestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestServiceImpl implements RestService {
	private final RestMapper restMapper;
	@Override
	public String hi() {
		return "hi";
	}
	@Override
	public List<RestaurantVO> getRestList() {
		
		return restMapper.seletAllRestList();
	}
	@Override
	public RestaurantVO getRest(Integer id) throws RestNotFoundException{
		Optional<RestaurantVO> findRestOptional = restMapper.selectRestById(id);
		RestaurantVO findRest=null;
		log.info("레스토랑 {}",findRestOptional);
		if(findRestOptional.isPresent()) {
			findRest = findRestOptional.get();
		}else {
			log.info("예외발생");
			throw new RestNotFoundException("해당 레스토랑은 존재하지 않습니다.");
		}
		return findRest;
	}
	@Override
	@Transactional
	public void createRest(RestaurantVO rest) {
	restMapper.insertRest(rest);
	rest.setMenuRestId();
	for(RestaurantMenuVO vo : rest.getMenus()) {
	restMapper.insertRestMenu(vo);
	}
	}
	@Override
	@Transactional
	public void updateRest(RestUpdateFormVO rest) {
		restMapper.updateRest(rest);
		rest.setMenuRestId();
		for(RestaurantMenuVO vo : rest.getMenus()) {
			restMapper.insertRestMenu(vo);
		}
		
	}
	@Override
	public void removeRest(long restId) {
		restMapper.deleteRest(restId);
		
	}
	@Override
	public void createReview(ReviewFormVO review) {
		// TODO Auto-generated method stub
		
	}
}
