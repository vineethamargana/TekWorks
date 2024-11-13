package com.nice.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nice.app.dto.HotelDTO;
import com.nice.app.entity.Hotel;
import com.nice.app.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	 HotelRepository hotelRepository;
	//public Object getallHotels;

	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public List<HotelDTO> findAll()
	{
	   List<Hotel> hotels = hotelRepository.findAll();
	   List<HotelDTO> allhotels = new ArrayList<HotelDTO>();
	   
	   for(Hotel hotel : hotels)
	   {
		   HotelDTO dto = new HotelDTO(hotel.getHotelId(),hotel.getHotelName(),hotel.getArea(),hotel.getArea());
		   allhotels.add(dto);
	   }
	   return allhotels;
	}
	

}
