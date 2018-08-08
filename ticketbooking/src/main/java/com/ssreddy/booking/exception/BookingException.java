package com.ssreddy.booking.exception;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Class to handle Booking exceptions. <br>
 * JIRA:  <br>
 */
public class BookingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7263252579600661697L;

	/**
     * Default Constructor.
     */
    public BookingException() {
        super();
    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingException(final String message) {
        super(message);
    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingException(final String message,
            final Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingException(final Throwable cause) {
        super(cause);
    }

}
