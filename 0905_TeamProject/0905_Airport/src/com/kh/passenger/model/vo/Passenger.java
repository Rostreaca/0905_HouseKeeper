package com.kh.passenger.model.vo;

import java.util.Objects;

public class Passenger {

	private int passId;
	private String passName;
	private String passNo;
	private String passCountry;
	private String flight;
	private String phone;
	private String seat;
	public Passenger(int passId, String passName, String passNo, String passCountry, String flight, String phone,
			String seat) {
		super();
		this.passId = passId;
		this.passName = passName;
		this.passNo = passNo;
		this.passCountry = passCountry;
		this.flight = flight;
		this.phone = phone;
		this.seat = seat;
	}
	public int getPassId() {
		return passId;
	}
	public String getPassName() {
		return passName;
	}
	public String getPassNo() {
		return passNo;
	}
	public String getPassCountry() {
		return passCountry;
	}
	public String getFlight() {
		return flight;
	}
	public String getPhone() {
		return phone;
	}
	public String getSeat() {
		return seat;
	}
	@Override
	public int hashCode() {
		return Objects.hash(flight, passCountry, passId, passName, passNo, phone, seat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return Objects.equals(flight, other.flight) && Objects.equals(passCountry, other.passCountry)
				&& passId == other.passId && Objects.equals(passName, other.passName)
				&& Objects.equals(passNo, other.passNo) && Objects.equals(phone, other.phone)
				&& Objects.equals(seat, other.seat);
	}
	
	
	
}
