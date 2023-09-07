package com.lcwd.microservices.service;

import java.util.List;

import com.lcwd.microservices.enttities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	Hotel getSingleHotel(String hotelId);
	
	List<Hotel> getAllHotels();

}
