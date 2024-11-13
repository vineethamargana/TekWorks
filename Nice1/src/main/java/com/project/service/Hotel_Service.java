package com.project.service;

import java.util.List;

import com.project.dto.HotelDTO;
import com.project.models.Hotel_Model;

public interface Hotel_Service {
	
	public Hotel_Model addHotel(Hotel_Model hotel_Model);
	public String removeHotel(Long hid);
	public Hotel_Model getHotelById(Long hid);
	public List<HotelDTO> findAll();
//	String selectHotel(Long cid, Long hotelid, int days);
//	public String selectRoom(Long cid, Long hotelid, int days);
	public String selectHotel(Long cid, Long hotelid, int days);
	

}
