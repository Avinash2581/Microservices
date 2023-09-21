package com.alibou.demo.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibou.demo.entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/users/{userId}")
	List<Rating> getRatingByUserId(@PathVariable String userId);
	
}
