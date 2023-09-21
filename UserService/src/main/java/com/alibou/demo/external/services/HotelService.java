package com.alibou.demo.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alibou.demo.entity.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotels/getHotel/{hotelId}")
	Hotel getHotelByHoteId(@PathVariable("hotelId") String hotelId);

}
