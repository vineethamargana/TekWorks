package com.nice.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nice.app.entity.Hotel;
import com.nice.app.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	 HotelRepository hotelRepository;

	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

}
