package com.nice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nice.app.dto.HotelDTO;
import com.nice.app.entity.Hotel;
import com.nice.app.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {


    @Autowired
    HotelService hotelService;

    @PostMapping("/addhotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }
    
    @GetMapping("getallhotels")
    public ResponseEntity<List<HotelDTO>> getallHotels()
    {
		return new ResponseEntity<>(hotelService.findAll(),HttpStatus.OK); // return all the data from the db
    }
    
}
