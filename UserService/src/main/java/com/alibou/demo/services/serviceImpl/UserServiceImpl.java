package com.alibou.demo.services.serviceImpl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibou.demo.entity.User;
import com.alibou.demo.exceptions.ResourceNotFoundException;
import com.alibou.demo.repository.UserRepository;
import com.alibou.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		//generate userId
	String randomUserId	=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with this userId"+" : "+userId));
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
