package com.ssreddy.booking.exception;

public class BookingInternalException extends BookingException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -177406307804560758L;

	/**
     * Default Constructor.
     */
    public BookingInternalException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingInternalException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingInternalException(final String message, final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingInternalException(final Throwable cause) {
        super(cause);

    }
}
