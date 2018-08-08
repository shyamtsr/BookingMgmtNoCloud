package com.ssreddy.booking.exception;

public class BookingBusinessValidationException extends BookingException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5668000970574456740L;

	/**
     * Default Constructor.
     */
    public BookingBusinessValidationException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingBusinessValidationException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingBusinessValidationException(final String message,
            final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingBusinessValidationException(final Throwable cause) {
        super(cause);

    }

}
