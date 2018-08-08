package com.ssreddy.booking.exception;

public class BookingRequestValidationException  extends BookingException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7218901301199511552L;

	/**
     * Default Constructor.
     */
    public BookingRequestValidationException() {
        super();

    }

    /**
     * Parameterized Constructor with String parameter.
     *
     * @param message InstanceOf String.
     */
    public BookingRequestValidationException(final String message) {
        super(message);

    }

    /**
     * Parameterized Constructor with String and Throwable parameters.
     *
     * @param message InstanceOf String.
     * @param cause InstanceOf Throwable.
     */
    public BookingRequestValidationException(final String message, final Throwable cause) {
        super(message, cause);

    }

    /**
     * Parameterized Constructor with Throwable parameters.
     *
     * @param cause InstanceOf Throwable.
     */
    public BookingRequestValidationException(final Throwable cause) {
        super(cause);

    }
    
}
