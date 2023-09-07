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

import com.lcwd.microservices.entities.Rating;
import com.lcwd.microservices.service.RatingService;
@RestController
@RequestMapping("/ratings")
@CrossOrigin("*")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create rating
	@PostMapping("/create")
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating){
		return new ResponseEntity<Rating>(ratingService.createRating(rating),HttpStatus.CREATED);
	}
	
	//get all
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getRatings(){
		return new ResponseEntity<List<Rating>>(ratingService.getRatings(),HttpStatus.OK);
	}
	
	//getall
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingsByUserId(userId),HttpStatus.OK);
	}
	
	//getAllByRatingID
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") String hotelId){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
	}
	
}
