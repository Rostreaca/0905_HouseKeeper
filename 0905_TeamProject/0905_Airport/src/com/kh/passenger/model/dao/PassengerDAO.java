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
import com.kh.passenger.model.dto.PassengerDTO;
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
	
	public List<Passenger> findByFlight(Connection conn, String flight) {
		List<Passenger> passengers = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByFlight");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, flight);
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
	
	public int save(Connection conn, PassengerDTO pd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("save");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pd.getPassName());
			pstmt.setString(2, pd.getPassNo());
			pstmt.setString(3, pd.getPassCountry());
			pstmt.setString(4, pd.getFlight());
			pstmt.setString(5, pd.getPhone());
			pstmt.setString(6, pd.getSeat());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int update(Connection conn, PassengerDTO pd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("update");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pd.getFlight());
			pstmt.setString(2, pd.getSeat());
			pstmt.setString(3, pd.getPassName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int delete(Connection conn, int passId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, passId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
