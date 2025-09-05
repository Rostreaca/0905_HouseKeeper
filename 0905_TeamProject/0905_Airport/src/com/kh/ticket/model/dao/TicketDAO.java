package com.kh.ticket.model.dao;

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
import com.kh.ticket.model.vo.Ticket;

public class TicketDAO {
	
	private Properties prop = new Properties();
	
	public TicketDAO() {
		try {
			prop.loadFromXML(new FileInputStream("resources/ticket-mapper.xml"));
		}catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	
	public int insertTicket(Connection conn, Ticket ticket) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String insert = prop.getProperty("insertTicket");
		
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, ticket.getFlight());
			pstmt.setDate(2, ticket.getDepartureDate());
			pstmt.setString(3, ticket.getBoardingTime());
			pstmt.setString(4, ticket.getGate());
			pstmt.setString(5, ticket.getDestination());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public List<Ticket> findAll(Connection conn) {
		
		List<Ticket> tickets = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String select = prop.getProperty("findAll");
		try {
			pstmt = conn.prepareStatement(select);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Ticket ticket = new Ticket(rset.getString("FLIGHT")
						 				 , rset.getDate("DEPARTURE_DATE")
						 				 , rset.getString("BOARDING_TIME")
						 				 , rset.getString("GATE")
						 				 , rset.getString("DESTINATION"));
				tickets.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return tickets;
		
	}
	
}
