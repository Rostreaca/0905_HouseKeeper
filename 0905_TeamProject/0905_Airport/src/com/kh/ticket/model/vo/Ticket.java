package com.kh.ticket.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Ticket {
	
	private String flight;
	private Date departureDate;
	private String boardingTime;
	private String gate;
	private String destination;
	
	public Ticket() {
		super();
	}

	public Ticket(String flight, Date departureDate, String boardingTime, String gate, String destination) {
		super();
		this.flight = flight;
		this.departureDate = departureDate;
		this.boardingTime = boardingTime;
		this.gate = gate;
		this.destination = destination;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Ticket [flight=" + flight + ", departureDate=" + departureDate + ", boardingTime=" + boardingTime
				+ ", gate=" + gate + ", destination=" + destination + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardingTime, departureDate, destination, flight, gate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(boardingTime, other.boardingTime) && Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(destination, other.destination) && Objects.equals(flight, other.flight)
				&& Objects.equals(gate, other.gate);
	}
	
	
}
