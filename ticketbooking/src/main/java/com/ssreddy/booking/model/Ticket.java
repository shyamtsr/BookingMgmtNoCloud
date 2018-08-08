package com.ssreddy.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ticketId;

	private String passengerName;

	private String bookingDate;

	private String sourceStation;

	private String destinationStation;

	private String email;

	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	//
	// public Ticket(Integer ticketId, String passengerName, String bookingDate,
	// String sourceStation,
	// String destinationStation, String email) {
	// super();
	// this.ticketId = ticketId;
	// this.passengerName = passengerName;
	// this.bookingDate = bookingDate;
	// this.sourceStation = sourceStation;
	// this.destinationStation = destinationStation;
	// this.email = email;
	// }

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", bookingDate=" + bookingDate
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", email=" + email
				+ "]";
	}

}
