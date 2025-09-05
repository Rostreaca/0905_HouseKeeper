package com.kh.passenger.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.passenger.model.vo.Passenger;

public class PassengerDAO {

	private Properties prop = new Properties();
	
	public PassengerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("resources/passenger-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Passenger> findAll(Connection conn){
		List<Passenger> passengers = new ArrayList();
		PreparedStatement pstmt = null;
	    ResultSet rset = null;
	    
	    String sql = prop.getProperty("findAll");
	    
	    try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				passengers.add(new Passenger(rset.getInt("PASS_ID")
						                    ,rset.getString("PASS_NAME")
						                    ,rset.getString("PASS_NO")
						                    ,rset.getString("PASS_COUNTRY")
						                    ,rset.getString("FLIGHT")
						                    ,rset.getString("PHONE")
						                    ,rset.getString("SEAT")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return passengers;
	}
	
	public Passenger findByFlight(Connection conn, String flight) {
		Passenger pass = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flight);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pass = new Passenger(rset.getInt("PASS_ID")
				                    ,rset.getString("PASS_NAME")
				                    ,rset.getString("PASS_NO")
				                    ,rset.getString("PASS_COUNTRY")
				                    ,rset.getString("FLIGHT")
				                    ,rset.getString("PHONE")
				                    ,rset.getString("SEAT"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return pass;
	}
	
	public List<Passenger> findByKeyword(Connection conn, String keyword){
		List<Passenger> passengers = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				passengers.add(new Passenger(rset.getInt("PASS_ID")
						                    ,rset.getString("PASS_NAME")
						                    ,rset.getString("PASS_NO")
						                    ,rset.getString("PASS_COUNTRY")
						                    ,rset.getString("FLIGHT")
						                    ,rset.getString("PHONE")
						                    ,rset.getString("SEAT")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return passengers;
	}
}
