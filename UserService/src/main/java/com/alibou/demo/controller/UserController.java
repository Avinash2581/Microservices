package com.alibou.demo.controller;

import java.util.List;

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

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("request proccessing");
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
		return new ResponseEntity<User>(userService.getUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsersList(){
		
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	
	
	
	
}
