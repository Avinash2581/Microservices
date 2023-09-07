package com.alibou.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alibou.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
