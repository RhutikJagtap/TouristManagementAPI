package com.rj.TouristManagement.service;

import java.util.List;

import com.rj.TouristManagement.entity.Tourist;
import com.rj.TouristManagement.exception.TouristNotFoundException;

public interface TouristService {

	String registerTourist(Tourist tourist);
	
	Tourist fetchTouristById(Long touristId)throws TouristNotFoundException;
	
	List<Tourist> fetchAllTourist();
	
	String updateTouristInfo(Tourist tourist)throws TouristNotFoundException;

	String updateTouristInfo(Long touristId, Double budget)throws TouristNotFoundException;
	
	String deleteTouristById(Long touristId) throws TouristNotFoundException;
	
	
}
