package com.kh.passenger.model.dto;

public class PassengerDTO {

	private String passName;
	private String passNo;
	private String passCountry;
	private String flight;
	private String phone;
	private String seat;
	public PassengerDTO() {
		super();
	}
	
	public PassengerDTO(String passName, String passNo, String passCountry, String flight, String phone, String seat) {
		super();
		this.passName = passName;
		this.passNo = passNo;
		this.passCountry = passCountry;
		this.flight = flight;
		this.phone = phone;
		this.seat = seat;
	}

	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	public String getPassNo() {
		return passNo;
	}
	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}
	public String getPassCountry() {
		return passCountry;
	}
	public void setPassCountry(String passCountry) {
		this.passCountry = passCountry;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
		return "PassengerDTO [passName=" + passName + ", passNo=" + passNo + ", passCountry=" + passCountry
				+ ", flight=" + flight + ", phone=" + phone + ", seat=" + seat + "]";
	}
	
	
}
