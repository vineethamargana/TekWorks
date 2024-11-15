package com.project.serviceimplements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.ApiResponse;
import com.project.dto.HotelDTO;
import com.project.enums.RoomTypes;
import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.CustomerRepository;
import com.project.repository.Hotel_Repository;
import com.project.service.Hotel_Service;

@Service
public class HotelServiceImpl implements Hotel_Service {

	HashMap<RoomTypes, Double> obj = new HashMap<RoomTypes, Double>();
	HashMap<String, Double> fc = new HashMap<String, Double>();
	ArrayList<String> food_list = new ArrayList<String>();
	Hotel_Model hm = new Hotel_Model();

	public HotelServiceImpl() {
		obj.put(RoomTypes.Suite, 2000.0);
		obj.put(RoomTypes.Delux, 1500.0 );
		obj.put(RoomTypes.Non_delux, 30000.0);
		obj.put(RoomTypes.Villah, 1500.0);

		fc.put("chicken curry", 250.0);
		fc.put("butter chicken ", 450.0);
		fc.put("mutton curry", 550.0);
		fc.put("fish curry", 250.0);
		fc.put("prawns curry", 750.0);
		fc.put("paneer curry", 150.0);
		fc.put("mushroom curry", 150.0);
		fc.put("chilli chicken ", 250.0);
		fc.put("chicken lolipop", 250.0);
		fc.put("chicken biryani", 350.0);
		fc.put("chicken mandi", 750.0);
		fc.put("mutton mandi", 950.0);
		fc.put("mutton biryani", 550.0);
		fc.put("gulabjam", 50.0);

	}

	@Autowired
	private Hotel_Repository hotel_Repository;
	@Autowired
	private CustomerRepository cr;
	

    @Override
    public ResponseEntity<ApiResponse<Hotel_Model>> addHotel(HotelDTO hoteldto) {
    	
        boolean savedHotel = hotel_Repository.existsById(hoteldto.getHotelId());
        if(savedHotel==false)
        {
          Hotel_Model addhotel = new Hotel_Model(hoteldto.getHotelId(), hoteldto.getHotelName(), hoteldto.getAddress());
          ApiResponse<Hotel_Model> response = new ApiResponse<>( HttpStatus.CREATED.value(),"Hotel added successfully", addhotel);
        
         return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else
        {
        	 throw new Mycustomexception("Hotel with ID " + hoteldto.getHotelId() + "already exist", HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<String>> removeHotel(Long hotelid) {
        if (hotel_Repository.existsById(hotelid)) {
            hotel_Repository.deleteById(hotelid);
            ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(),"Hotel deleted successfully", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new Mycustomexception("Hotel with ID " + hotelid + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Hotel_Model>> getHotelById(Long hotelid) {
        Hotel_Model hotel = hotel_Repository.findById(hotelid)
            .orElseThrow(() -> new Mycustomexception("Hotel not found", HttpStatus.NOT_FOUND));
        ApiResponse<Hotel_Model> response = new ApiResponse<>( HttpStatus.OK.value(),"Hotel found", hotel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<List<HotelDTO>>> findAll() {
        List<Hotel_Model> hotels = hotel_Repository.findAll();
        List<HotelDTO> allhotels = new ArrayList<>();
        for (Hotel_Model hotel : hotels) {
            HotelDTO dto = new HotelDTO(hotel.getHotelid(), hotel.getHotelname(), hotel.getHotelAddress());
            allhotels.add(dto);
        }
        ApiResponse<List<HotelDTO>> response = new ApiResponse<>( HttpStatus.OK.value(),"All hotels retrieved successfully", allhotels);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<Double>> selectType(Long cid, Long hotelid, List<RoomTypes> roomtype, int days) {
        if (days <= 0) {
            throw new Mycustomexception("Days must be greater than zero", HttpStatus.BAD_REQUEST);
        }

        Optional<Customer_Model> customer = cr.findById(cid);
        Optional<Hotel_Model> hotel = hotel_Repository.findById(hotelid);
       
        for (RoomTypes type : roomtype) {
            if (!obj.containsKey(type)) {
                throw new Mycustomexception("Room type " + type + " not available", HttpStatus.NOT_FOUND);
            }
        }


        if (customer.isPresent() && hotel.isPresent()) {
            Hotel_Model hm = hotel.get();
            
            double totalCost = 0;
            for (RoomTypes type : roomtype) {
                Double roomTypePrice = obj.get(type);
                totalCost += roomTypePrice != null ? roomTypePrice * days : 0;
            }
            hm.setRoomBill((int) totalCost);
            hotel_Repository.save(hm);

            ApiResponse<Double> response = new ApiResponse<>( HttpStatus.OK.value(),"Room type selected successfully", totalCost);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new Mycustomexception("Customer or Hotel not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ApiResponse<String>> foodSelect(Long cid, String item, Integer quantity) {
        Optional<Hotel_Model> optionalHm = hotel_Repository.findById(cid);

        if (optionalHm.isPresent()) {
            if (fc.containsKey(item)) {
                Hotel_Model hm = optionalHm.get();
                food_list.add(item);
                Double itemCost = fc.get(item) * quantity;
                Double currentFoodBill = hm.getFoodBil() != null ? hm.getFoodBil() : 0.0;
                currentFoodBill += itemCost;
                hm.setFoodBil(currentFoodBill);
                hotel_Repository.save(hm);

                ApiResponse<String> response = new ApiResponse<>( HttpStatus.OK.value(), "Total food bill updated: " + currentFoodBill);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new Mycustomexception("Item not found", HttpStatus.NOT_FOUND);
            }
        } else {
            throw new Mycustomexception("Invalid customer ID", HttpStatus.NOT_FOUND);
        }
    }


}