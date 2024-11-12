package com.nice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nice.app.entity.Hotel;
import com.nice.app.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {


    @Autowired
    HotelService hotelService;

    // Endpoint to add a hotel
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }
}
