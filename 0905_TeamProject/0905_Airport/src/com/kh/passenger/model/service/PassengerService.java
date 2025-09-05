package com.kh.passenger.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.passenger.model.dao.PassengerDAO;
import com.kh.passenger.model.dto.PassengerDTO;
import com.kh.passenger.model.vo.Passenger;

public class PassengerService {
	
	private Connection conn = null;
	
	public PassengerService() {
		conn = getConnection();
	}
	
	public List<Passenger> findAll(){
		
		List<Passenger> passengers = new PassengerDAO().findAll(conn);
		
		close(conn);
		
		return passengers;
	}
	
	public List<Passenger> findByFlight(String flight) {
		List<Passenger> passengers = new PassengerDAO().findByFlight(conn,flight);
		
		close(conn);
		
		return passengers;
	}
	
	public List<Passenger> findByKeyword(String keyword){
		List<Passenger> passengers = new PassengerDAO().findByKeyword(conn, keyword);
		
		close(conn);
		
		return passengers;
	}
	
	public int save(PassengerDTO pd) {
		int result = new PassengerDAO().save(conn,pd);
		if(result > 0) {
			commit(conn);			
		}
		close(conn);
		
		return result;
	}
	
	public int update(PassengerDTO pd) {
		int result = new PassengerDAO().update(conn,pd);
		if(result > 0) {
			commit(conn);			
		}
		close(conn);
		return result;
	}
	
	public int delete(int passId) {
		int result = new PassengerDAO().delete(conn,passId);
		if(result >0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
}
