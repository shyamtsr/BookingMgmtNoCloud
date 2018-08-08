package com.ssreddy.booking.exception;

public class BookingCommunicationException extends BookingInternalException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5935604884926101508L;

	/**
     * Default Constructor.
     */
    public BookingCommunicationException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingCommunicationException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingCommunicationException(final String message,
            final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingCommunicationException(final Throwable cause) {
        super(cause);

    }
    
}
