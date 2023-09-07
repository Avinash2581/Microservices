package com.alibou.demo.services;

import java.util.List;

import com.alibou.demo.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	User getUser(String userId);
	
	List<User> getAllUser();
	
	void deleteUserById(String userId);

}
