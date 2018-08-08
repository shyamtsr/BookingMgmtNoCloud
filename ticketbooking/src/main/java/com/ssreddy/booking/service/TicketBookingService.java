package com.ssreddy.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssreddy.booking.dao.TicketBookingRepository;
import com.ssreddy.booking.dao.TicketBookingRepositoryDao;
import com.ssreddy.booking.exception.BookingException;
import com.ssreddy.booking.model.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingRepository bookingRepository;
	
	@Autowired
	private TicketBookingRepositoryDao ticketBookingRepositoryDao;

	public Ticket bookingTicket(Ticket ticketInfo) {
		Ticket ticket = new Ticket();
		if (ticketInfo != null) {
			ticket = bookingRepository.save(ticketInfo);
		}
		return ticket;
	}

	/*public Ticket getBookingInfo(int ticketId) {
		Ticket ticketInfo = new Ticket();
		if (ticketId != 0) {
			ticketInfo = bookingRepository.findOne(ticketId);
		}

		return ticketInfo;
	}*/
	
	public Ticket getBookingInfo(int ticketId) throws BookingException {
		Ticket ticketInfo = new Ticket();
		if (ticketId != 0) {
			ticketInfo = ticketBookingRepositoryDao.fetchTicketBookingInfo(ticketId);
		}

		return ticketInfo;
	}
	
	

	public List<Ticket> getAllBookings() throws BookingException {

		List<Ticket> allBookingInfo = (List<Ticket>) ticketBookingRepositoryDao.fetchAllBookingInfo();

		return allBookingInfo;
	}

	public String updateBookingDetails(final Ticket ticketInfo) throws BookingException {

		String updateBookingInfo = ticketBookingRepositoryDao.updateBookingInfo(ticketInfo, ticketInfo.getTicketId());
		
		return updateBookingInfo;
	}

	public String cancelBookings(Integer bookingId) {

		String response = "";
		Integer ticketId = 2;//getBookingInfo(bookingId).getTicketId();
		if (ticketId == bookingId) {
			bookingRepository.deleteById(bookingId);
			response = "Cancel Ticket Booking " + ticketId + ".";
		} else {
			response = "Invalid Ticket Id : " + ticketId + ", Please Enter Valid Booking Info";
		}
		return response;
	}

}
