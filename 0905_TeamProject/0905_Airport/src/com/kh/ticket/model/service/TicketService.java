package com.kh.ticket.model.service;

import java.sql.Connection;

import com.kh.ticket.model.dao.TicketDAO;
import com.kh.ticket.model.vo.Ticket;

import static com.kh.common.JDBCTemplate.*;

public class TicketService {
	
	private Connection conn = null;
	
	public TicketService() {
		this.conn = getConnection();
	}
	
	public int insertTicket(Ticket ticket) {
		int result = new TicketDAO().insertTicket(conn, ticket);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
		
		
	}
	
}
