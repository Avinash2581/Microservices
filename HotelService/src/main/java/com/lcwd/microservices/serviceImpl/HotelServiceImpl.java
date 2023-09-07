package com.lcwd.microservices.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.microservices.enttities.Hotel;
import com.lcwd.microservices.repository.HotelRepository;
import com.lcwd.microservices.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getSingleHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException());
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

}
