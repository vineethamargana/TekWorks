package com.project.serviceimplements;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.exception.Mycustomexception;
import com.project.models.Hotel_Model;
import com.project.repository.Admin_Repository;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Admin_Service;

@Service
public class AdminServiceImpl implements Admin_Service {

	@SuppressWarnings("unused")
	@Autowired
	private Admin_Repository admin_Repository;

	@Autowired
	private Hotel_Repository hotel_Repository;

	@Autowired
	private CustomerRepository customerRespository;

	@Override
	public Map<String, Double> getRoomBill(Long cid) {
		// Check if the customer exists using findById
		Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

		if (optionalHotelModel.isPresent())
		{
			Hotel_Model hotelModel = optionalHotelModel.get();

			// Create a map to hold the bill details
			Map<String, Double> billDetails = new HashMap<>();
			billDetails.put("roomBill", hotelModel.getRoomBill() != null ? hotelModel.getRoomBill() : 0.0);
			billDetails.put("foodBill", hotelModel.getFoodBil() != null ? hotelModel.getFoodBil() : 0.0);
			billDetails.put("totalBill", (hotelModel.getRoomBill() != null ? hotelModel.getRoomBill() : 0.0)
					+ (hotelModel.getFoodBil() != null ? hotelModel.getFoodBil() : 0.0));

			// Return a ResponseEntity with the bill details
			return billDetails;
		}
		else {
			throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
		}
	}

}
