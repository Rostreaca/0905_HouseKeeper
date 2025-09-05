package com.kh.ticket.controller;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

import com.kh.ticket.model.service.TicketService;
import com.kh.ticket.model.vo.Ticket;

public class TicketController {
	
	private Properties prop = new Properties();
	
	public int insertTicket(String flight, Date departureDate, String boardingTime, String gate, String destination) {
		
		Ticket ticket = new Ticket(flight,departureDate, boardingTime, gate,destination);
		
		int result = new TicketService().insertTicket(ticket);
		
		return result;
	}
	
	public List<Ticket> findAll() {
		
		List<Ticket> tickets = new TicketService().findAll();
		
		return tickets;
	}
	
	
}
