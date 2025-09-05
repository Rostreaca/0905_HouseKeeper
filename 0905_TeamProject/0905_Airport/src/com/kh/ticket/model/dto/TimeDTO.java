package com.kh.ticket.model.dto;

import java.sql.Date;
import java.util.Objects;

public class TimeDTO {
	
	private String flight;
	private String boardingTime;
	private String newTime;
	
	public TimeDTO() {
		super();
	}

	public TimeDTO(String flight, String boardingTime, String newTime) {
		super();
		this.flight = flight;
		this.boardingTime = boardingTime;
		this.newTime = newTime;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	@Override
	public String toString() {
		return "TimeDTO [flight=" + flight + ", boardingTime=" + boardingTime + ", newTime=" + newTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardingTime, flight, newTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeDTO other = (TimeDTO) obj;
		return Objects.equals(boardingTime, other.boardingTime) && Objects.equals(flight, other.flight)
				&& Objects.equals(newTime, other.newTime);
	}

	
	
}
