package com.lcwd.microservices.service;

import java.util.List;

import com.lcwd.microservices.entities.Rating;

public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingsByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
