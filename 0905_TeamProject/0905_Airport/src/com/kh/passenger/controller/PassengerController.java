package com.kh.passenger.controller;

import java.util.List;

import com.kh.passenger.model.service.PassengerService;
import com.kh.passenger.model.vo.Passenger;

public class PassengerController {

	public List<Passenger> findAll(){
		
		List<Passenger> passengers = new PassengerService().findAll();
		
		return passengers;
		
	}
	
	public Passenger findByFlight(String flight) {
		
		Passenger pass = new PassengerService().findByFlight(flight);
		
		return pass;
	}
	
}
