package com.kh.ticket.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.function.Function;

import com.kh.ticket.model.dao.TicketDAO;
import com.kh.ticket.model.dto.TicketDTO;
import com.kh.ticket.model.dto.TimeDTO;
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
	
	private <T> T executeQuery(Function<Connection, T> daoFunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daoFunction.apply(conn);
		close(conn);
		return result;
	}
	
	public List<Ticket> findAll() {
		return executeQuery(new TicketDAO()::findAll);
	}
	
	public TicketDTO findByName(String passName) {
		return executeQuery(conn -> new TicketDAO().findByName(conn, passName));
	}
	
	public int timeUpdate(TimeDTO td) {
		
		
		int result = new TicketDAO().timeUpdate(conn, td);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
		
	}
	
}
