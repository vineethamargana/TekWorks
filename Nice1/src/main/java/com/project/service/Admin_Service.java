package com.project.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.project.models.Admin_Model;

public interface Admin_Service {

	public  Map<String, Double> getRoomBill(Long cid);
}
