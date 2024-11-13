package com.project.serviceimplements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.HotelDTO;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Hotel_Service;

@Service
public class HotelServiceImpl implements Hotel_Service{
	
	
	@Autowired
	private Hotel_Repository hotel_Repository;
	
	@Autowired 
	private CustomerRepository cr;

	 @Override
	public Hotel_Model addHotel(Hotel_Model hotel_Model) {
		return hotel_Repository.save(hotel_Model);
	}
	
	 @Override
	public String removeHotel(Long hotelid) 
	 {
		hotel_Repository.deleteById(hotelid);
		return "deleted hotel with"+hotelid+"Successfully";
	 }
	
	 @Override
	public Hotel_Model getHotelById(Long hotelid) {
		return hotel_Repository.findById(hotelid)
				.orElseThrow(() -> new RuntimeException("Hotel not found"));
	}
	 @Override
	public List<HotelDTO> findAll() {
		   List<Hotel_Model> hotels = hotel_Repository.findAll();
		   List<HotelDTO> allhotels = new ArrayList<HotelDTO>();
		   
		   for(Hotel_Model hotel_Model : hotels)
		   {
			   HotelDTO dto = new HotelDTO(hotel_Model.getHotelid(),hotel_Model.getHotelname(),hotel_Model.getHotelAddress());
			   allhotels.add(dto);
		   }
		   return allhotels;
		
	}
	@Override
	public String generatebill(Long cid,Long hotelid,int days)
	{
		Optional<Customer_Model> customer = cr.findById(cid);
		Optional<Hotel_Model> hotel = hotel_Repository.findById(hotelid);
		double price = 1;
		if(customer.isPresent() && hotel.isPresent())
		{
			Double perdaycost = hotel.get().getCostperDay();
			price = price * days * perdaycost;
			return "\nSelected room type :"+hotel.get().getHoteltype()+", "+"\nTotal price: "+price;
		}
		else 
		{
			return "Room type not available";
		}
		
	}

	@Override
	public HotelDTO updateHotel(Long hotelid, HotelDTO hoteldto)
	{
		Optional<Hotel_Model> hotel = hotel_Repository.findById(hotelid);
        if(hotel.isPresent())
        {
         hotel.get().setHotelname(hoteldto.getHotelName());
         hotel.get().setHotelAddress(hoteldto.getAddress());
         hotel.get().setHotelid(hoteldto.getHotelId());
         hotel_Repository.save(hotel);
        }
	}
}
