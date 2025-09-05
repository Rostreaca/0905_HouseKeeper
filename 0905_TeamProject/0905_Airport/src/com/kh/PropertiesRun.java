package com.kh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			prop.store(new FileOutputStream("driver.properties"),"setting for DBMS");
			prop.storeToXML(new FileOutputStream("passenger-mapper.xml"), "Passenger SQL for DBMS");
			prop.storeToXML(new FileOutputStream("ticket-mapper.xml"),"Ticket SQL for DBMS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
