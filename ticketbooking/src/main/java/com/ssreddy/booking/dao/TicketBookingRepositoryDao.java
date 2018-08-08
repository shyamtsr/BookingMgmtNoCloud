/*
 * Copyright (c) 2018 SSR Technology & Services private limited. All rights
 * reserved. This software is the confidential and proprietary information of
 * SSR Technology & Services private limited. This file is part of Booking.
 */
package com.ssreddy.booking.dao;

import java.util.List;

import com.ssreddy.booking.exception.BookingDataAccessException;
import com.ssreddy.booking.model.Ticket;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description :Interface class to handle DB calls, required to create the new
 * change order. <br>
 * JIRA: <br>
 */
public interface TicketBookingRepositoryDao {

	/**
	 * 
	 * @param ticket
	 *            instance of Ticket
	 * @return
	 */
	public Ticket insertTicketBooking(final Ticket ticket) throws BookingDataAccessException;

	public Ticket fetchTicketBookingInfo(final Integer ticketId) throws BookingDataAccessException;

	public int existanceBookingCount(final Integer ticketId) throws BookingDataAccessException;

	public List<Ticket> fetchAllBookingInfo() throws BookingDataAccessException;

	public String updateBookingInfo(final Ticket ticketInfo, final Integer ticketId) throws BookingDataAccessException;

	public String cancelBookingDetails(final Integer ticketId) throws BookingDataAccessException;

	public int checkBookingIdExist(final Integer ticketId) throws BookingDataAccessException;

}
