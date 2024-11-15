package com.project.serviceimplements;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.ApiResponse;
import com.project.exception.Mycustomexception;
import com.project.models.Admin_Model;
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
	public ResponseEntity<ApiResponse<String>> getRoomBill(Long cid) {
	    Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

	    if (optionalHotelModel.isPresent()) {
	        Hotel_Model hotelModel = optionalHotelModel.get();
	        String bill = "Room bill:" + hotelModel.getRoomBill();

	        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "Bill details", bill);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	        throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
	    }
	}


	@Override
	public ResponseEntity<ApiResponse<String>> getFoodBill(Long cid) {
		// Check if the customer exists using findById
		Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

		if (optionalHotelModel.isPresent()) {
			Hotel_Model hotelModel = optionalHotelModel.get();
			// Safely return the room bill or 0.0 if it's null
			// return hotelModel.getRoomBill() != null ? hotelModel.getFoodBil(): 0.0;
			 String foodbill ="Food Bill: " + hotelModel.getFoodBil();
			 ApiResponse<String> response = new ApiResponse<String>(HttpStatus.OK.value(),"Food Bill", foodbill);
			 return new ResponseEntity<>(response,HttpStatus.OK);
		} else {
			throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<ApiResponse<Double>> getTotalBill(Long cid) {
		Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

		if (optionalHotelModel.isPresent()) {
			Hotel_Model hotelModel = optionalHotelModel.get();
			// Safely return the room bill or 0.0 if it's null
			Double roombill = hotelModel.getRoomBill() != null ? hotelModel.getRoomBill() + hotelModel.getFoodBil() : 0.0;
			ApiResponse<Double> response = new ApiResponse<Double>(HttpStatus.OK.value(),"Room Bill", roombill);
			return new ResponseEntity<ApiResponse<Double>>(response,HttpStatus.OK);
		} else {
			throw new Mycustomexception("Customer with ID " + cid + " not found", HttpStatus.NOT_FOUND);
		}

	}
}
