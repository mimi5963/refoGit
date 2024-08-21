package com.rest.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rest.domain.RestUpdateFormVO;
import com.rest.domain.RestaurantMenuVO;
import com.rest.domain.RestaurantVO;

@Mapper
@Repository
public interface RestMapper {

	List<RestaurantVO> seletAllRestList();

	Optional<RestaurantVO> selectRestById(Integer id);
	
	boolean insertRestMenu(RestaurantMenuVO rest);
	
	void insertRest(RestaurantVO rest);
	
	void updateRest(RestUpdateFormVO updateRest);

	void deleteRest(long restId);

}
