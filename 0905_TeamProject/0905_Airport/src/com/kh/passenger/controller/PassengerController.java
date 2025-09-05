package com.kh.passenger.controller;

import java.util.List;

import com.kh.passenger.model.dto.PassengerDTO;
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
	
	public List<Passenger> findByKeyword(String keyword){
		
		List<Passenger> passengers = new PassengerService().findByKeyword(keyword);
		
		return passengers;
	}
	
	public int save(PassengerDTO pd) {
		
		int result = new PassengerService().save(pd);
		
		return result;
	}
	
}
