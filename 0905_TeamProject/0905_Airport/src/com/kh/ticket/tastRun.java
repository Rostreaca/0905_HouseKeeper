package com.kh.ticket;

import com.kh.common.JDBCTemplate;
import com.kh.ticket.view.TicketView;

public class tastRun {

	public static void main(String[] args) { 
		JDBCTemplate.registDriver();
		TicketView tv = new TicketView();
		tv.mainMenu();
		
	}
	

}
