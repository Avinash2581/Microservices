package com.alibou.demo.services.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibou.demo.entity.Hotel;
import com.alibou.demo.entity.Rating;
import com.alibou.demo.entity.User;
import com.alibou.demo.exceptions.ResourceNotFoundException;
import com.alibou.demo.external.services.HotelService;
import com.alibou.demo.repository.UserRepository;
import com.alibou.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUser(String userId) {
		
		User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this userId"+" : "+userId));
	//fetch rating of the above user from rating service
		//rating object bhi rakh sakte hai
		Rating[] ratingOfUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		 logger.info("{}",ratingOfUser);
		 
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		 
		 List<Rating> ratingList=ratings.stream().map(rating -> {
			 
	//ResponseEntity<Hotel> forEntity		= restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/getHotel/"+rating.getHotelId(),Hotel.class);
			// Hotel hotel =forEntity.getBody();
			 
			//using feignclient {
			 
			 Hotel hotel =hotelService.getHotelByHoteId(rating.getHotelId());
			 
			 System.out.println(hotel.toString());
			 
			 
			 // }
			 
			// logger.info("response status code:{}", forEntity.getStatusCode());
			 //set the hotel to rating
			 rating.setHotel(hotel);
			 //return the rating
			 return rating;
		 }).collect(Collectors.toList());
		 
		 user.setRatings(ratingList);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(String userId) {
		userRepository.deleteById(userId);
	}

}
