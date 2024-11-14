package com.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Admin_Model;
import com.project.service.Admin_Service;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/admin")
public class Admin_Controller {
	
	
	@Autowired
	private Admin_Service admin_Service;
	
	@GetMapping("/getroombill/{cid}")
	public ResponseEntity<Map<String, Double>> get(@PathParam(value="cid") Long cid) {
		return new ResponseEntity<Map<String, Double>> (admin_Service.getRoomBill(cid),HttpStatus.OK);
	}
	
	

}
