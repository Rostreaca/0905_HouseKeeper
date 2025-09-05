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
	
	public List<Passenger> findByFlight(String flight) {
		
		List<Passenger> passengers = new PassengerService().findByFlight(flight);
		
		return passengers;
	}
	
	public List<Passenger> findByKeyword(String keyword){
		
		List<Passenger> passengers = new PassengerService().findByKeyword(keyword);
		
		return passengers;
	}
	
	public int save(PassengerDTO pd) {
		
		int result = new PassengerService().save(pd);
		
		return result;
	}
	public int update(PassengerDTO pd) {
		int result = new PassengerService().update(pd);
		
		return result;
	}
	
	public int delete(int passId) {
		int result = new PassengerService().delete(passId);
		
		return result;
	}
	
}
