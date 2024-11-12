package com.nice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nice.app.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
