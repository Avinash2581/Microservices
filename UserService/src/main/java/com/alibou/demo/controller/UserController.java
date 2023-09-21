package com.alibou.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.demo.entity.User;
import com.alibou.demo.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	private Logger logger =LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("request proccessing");
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	int retryCount=1;
	@GetMapping("/getUser/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod="ratingHotelFallback")
	@Retry(name="ratingHotelService",fallbackMethod="ratingHotelFallback")
	
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
		logger.info("Get single User Handler",retryCount);
		retryCount++;
		System.out.println(retryCount);
		return new ResponseEntity<User>(userService.getUser(userId),HttpStatus.OK);
	}
	
	//creating fall back method for circuitbreaker
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
		logger.info("Get Single User Handler:UserController",ex.getMessage());
	User user	=User.builder().email("dummy@gmail.com").
			fname("Dummy").lname("data").
			about("This user is creted dummy because some service is down ").build();
		
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsersList(){
		
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	
	
	
	
}
