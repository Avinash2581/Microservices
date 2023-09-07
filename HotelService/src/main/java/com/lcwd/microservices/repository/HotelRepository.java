package com.lcwd.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.microservices.enttities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
