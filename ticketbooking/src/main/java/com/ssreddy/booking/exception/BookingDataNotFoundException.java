package com.ssreddy.booking.exception;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Class to handle data not found exceptions. <br>
 * JIRA:  <br>
 */
public class BookingDataNotFoundException extends BookingException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -72991771981208425L;
	
	/**
     * Default Constructor.
     */
    public BookingDataNotFoundException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingDataNotFoundException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingDataNotFoundException(final String message,
            final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingDataNotFoundException(final Throwable cause) {
        super(cause);

    }
}
