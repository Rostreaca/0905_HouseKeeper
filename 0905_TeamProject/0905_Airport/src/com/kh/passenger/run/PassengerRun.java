package com.kh.passenger.run;

import com.kh.common.JDBCTemplate;
import com.kh.passenger.view.PassengerView;

public class PassengerRun {

	public static void main(String[] args) {
		
		JDBCTemplate.registDriver();
		
		PassengerView pv = new PassengerView();
		
		pv.mainMenu();
		
		
		
	}
	
}
