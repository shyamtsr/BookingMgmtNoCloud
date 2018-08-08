package com.ssreddy.booking.schedular;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ssreddy.booking.exception.BookingException;
import com.ssreddy.booking.model.Ticket;
import com.ssreddy.booking.service.TicketBookingService;

@Component
public class BookingSchedular {

	@Autowired
	private TicketBookingService bookingService;

	// @Scheduled(cron = "0/5 * * * * ?")
	public void getBookingSchedular() throws BookingException {

		List<Ticket> allBookings = bookingService.getAllBookings();

		if (CollectionUtils.isEmpty(allBookings)) {
			System.out.println(new Date().toString() + "Booking List is Empty");
		} else {
			System.out.println(new Date().toString() + "Booking List is not Empty : " + allBookings.size());
		}

	}

	// @Scheduled(initialDelay = 100, fixedRate = 100)
	public void fixedRateJob() throws InterruptedException {
		System.out.println(new Date().toString() + " Scheduled...");
		Thread.sleep(5000);
		System.out.println(new Date().toString() + " Ending...");
	}

	// @Scheduled(initialDelay = 1000, fixedDelay = 1000)
	public void fixedDelayJob() throws InterruptedException {
		System.out.println(new Date().toString() + " Starting...");
		Thread.sleep(5000);
		System.out.println(new Date().toString() + " Ending...");
	}

}
