package com.ssreddy.booking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssreddy.booking.dao.TicketBookingRepositoryDao;
import com.ssreddy.booking.exception.BookingDataAccessException;
import com.ssreddy.booking.model.Ticket;

/**
 * Author : Shyamsundar T <br>
 * Created on : 06th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Implementation class of TicketBookingRepositoryDao interface.
 * This class is to handle DB calls, required to create and update the ticket
 * booking. <br>
 * JIRA: <br>
 */
@Repository
public class TicketBookingRepositoryDaoImpl implements TicketBookingRepositoryDao {

	/**
	 * LOGGER instance of Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TicketBookingRepositoryDaoImpl.class);

	/**
	 * SQL_GET_BOOKING_DETAILS instance of String.
	 */
	@Value("${SQL_GET_BOOKING_DETAILS}")
	String SQL_GET_BOOKING_DETAILS;

	/**
	 * SQL_GET_ALL_BOOKING_DETAILS instance of String.
	 */
	@Value("${SQL_GET_ALL_BOOKING_DETAILS}")
	String SQL_GET_ALL_BOOKING_DETAILS;

	/**
	 * SQL_GET_ALL_BOOKING_DETAILS instance of String.
	 */
	@Value("${SQL_GET_BOOKINGID_COUNT}")
	String SQL_GET_BOOKINGID_COUNT;
	
	/**
	 * SQL_UPDATE_TICKETBOOKING instance of String.
	 */
	@Value("${SQL_UPDATE_TICKETBOOKING}")
	String SQL_UPDATE_TICKETBOOKING;
	
	
	/**
	 * userJdbcTemplate instance of JdbcTemplate.
	 */
	@Autowired
	@Qualifier("ticketJdbcTemplate")
	JdbcTemplate ticketJdbcTemplate;

	/**
	 * namedUserJdbcTemplate instance of NamedParameterJdbcTemplate.
	 */
	@Autowired
	@Qualifier("namedTicketJdbcTemplate")
	NamedParameterJdbcTemplate namedTicketJdbcTemplate;

	@Override
	public Ticket insertTicketBooking(Ticket ticket) throws BookingDataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @param bomId
	 *            instance of Integer.
	 * @return instance of Ticket.
	 * @throws BookingDataAccessException
	 *             exception.
	 */

	@Override
	public Ticket fetchTicketBookingInfo(Integer ticketId) throws BookingDataAccessException {

		LOGGER.info("*****fetchTicketBookingInfo - STARTS*****");
		Ticket ticketInfo = new Ticket();
		try {
			MapSqlParameterSource paramMap = new MapSqlParameterSource();
			paramMap.addValue("ticketId", ticketId);
			ticketInfo = (Ticket) namedTicketJdbcTemplate.queryForObject(SQL_GET_BOOKING_DETAILS, paramMap,
					new BeanPropertyRowMapper<>(Ticket.class));
		} catch (DataAccessException ex) {
			throw new BookingDataAccessException(ex);
		} catch (Exception ex) {
			throw new BookingDataAccessException(ex);
		}
		LOGGER.info("*****fetchTicketBookingInfo - ENDS*****");
		return ticketInfo;
	}

	@Override
	public int existanceBookingCount(Integer ticketId) throws BookingDataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ticket> fetchAllBookingInfo() throws BookingDataAccessException {
		LOGGER.info("*****fetchTicketBookingInfo - STARTS*****");
		List<Ticket> ticketInfo = new ArrayList<>();
		try {
			ticketInfo = (List<Ticket>) namedTicketJdbcTemplate.query(SQL_GET_ALL_BOOKING_DETAILS,
					new BeanPropertyRowMapper<>(Ticket.class));
		} catch (DataAccessException ex) {
			throw new BookingDataAccessException(ex);
		} catch (Exception ex) {
			throw new BookingDataAccessException(ex);
		}
		LOGGER.info("*****fetchTicketBookingInfo - ENDS*****");
		return ticketInfo;
	}

	@Override
	public String updateBookingInfo(Ticket ticketInfo, Integer ticketId) throws BookingDataAccessException {
		LOGGER.info("*****fetchTicketBookingInfo - STARTS*****");
		String response ="";
		try {
			if (checkBookingIdExist(ticketId) > 0) {

				/*MapSqlParameterSource paramMap = new MapSqlParameterSource();
				paramMap.addValue("ticket_id", ticketInfo.getTicketId())
						.addValue("passenger_name", ticketInfo.getPassengerName())
						.addValue("email", ticketInfo.getEmail())
						.addValue("source_station", ticketInfo.getSourceStation())
						.addValue("destination_station", ticketInfo.getDestinationStation());
				
				int count = namedTicketJdbcTemplate.update(SQL_UPDATE_TICKETBOOKING, paramMap);*/
				
				int update = ticketJdbcTemplate.update(SQL_UPDATE_TICKETBOOKING,
						new Object[]{ticketInfo.getPassengerName(),
								ticketInfo.getEmail(),
		                        ticketInfo.getSourceStation(),
		                        ticketInfo.getDestinationStation(),
		                        ticketId
		                    });
				System.out.println("Updated Booking count : " +update);
				if(update>0) {
					response = "Ticket Booking " + ticketId + " is Updated.";
				} else {
					response = "Invalid Ticket Id : " + ticketId + ", Please Enter Valid Booking Info";
				}		

			}
		} catch (DataAccessException ex) {
			throw new BookingDataAccessException(ex);
		} catch (Exception ex) {
			throw new BookingDataAccessException(ex);
		}
		LOGGER.info("*****fetchTicketBookingInfo - ENDS*****");
		return response;
	}

	@Override
	public String cancelBookingDetails(Integer ticketId) throws BookingDataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @param bookingId
	 *            instance of String.
	 * @return instance of int.
	 * @throws BookingDataAccessException
	 *             exception.
	 */
	@Override
	public int checkBookingIdExist(final Integer ticketId) throws BookingDataAccessException {
		LOGGER.info("*****checkBookingIdExist - STARTS*****");
		int noOfBookings = 0;
		try {
			noOfBookings = ticketJdbcTemplate.queryForObject(SQL_GET_BOOKINGID_COUNT, new Integer[] { ticketId },
					Integer.class);
		} catch (DataAccessException ex) {
			throw new BookingDataAccessException(ex);
		} catch (Exception ex) {
			throw new BookingDataAccessException(ex);
		}
		LOGGER.info("*****checkBookingIdExist - ENDS*****");
		return noOfBookings;
	}

}
