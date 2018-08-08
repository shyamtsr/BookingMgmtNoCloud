package com.ssreddy.booking.exception;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Class to handle data access exceptions. <br>
 * JIRA:  <br>
 */
public class BookingDataAccessException extends BookingInternalException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1824232256375459398L;

	/**
     * Default Constructor.
     */
    public BookingDataAccessException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingDataAccessException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingDataAccessException(final String message,
            final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingDataAccessException(final Throwable cause) {
        super(cause);

    }
    
}
