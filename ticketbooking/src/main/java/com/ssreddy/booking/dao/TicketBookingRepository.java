package com.ssreddy.booking.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssreddy.booking.model.Ticket;

public interface TicketBookingRepository extends CrudRepository<Ticket, Integer>{

}
