package com.lcwd.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.microservices.enttities.Hotel;
import com.lcwd.microservices.service.HotelService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		return new ResponseEntity<Hotel>(hotelService.createHotel(hotel),HttpStatus.CREATED);
	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelByHotelId(@PathVariable("hotelId") String hotelId){
		return new ResponseEntity<Hotel>(hotelService.getSingleHotel(hotelId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotelsInfo(){
		return new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(),HttpStatus.OK);
	}

	
}
