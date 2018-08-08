package com.ssreddy.booking.exception;

import static com.ssreddy.booking.common.BookingConstants.EXCEPTION_MSG;
import static com.ssreddy.booking.common.enums.IntegerEnum.INT_204;
import static com.ssreddy.booking.common.enums.IntegerEnum.INT_400;
import static com.ssreddy.booking.common.enums.IntegerEnum.INT_412;
import static com.ssreddy.booking.common.enums.IntegerEnum.INT_500;
import static com.ssreddy.booking.common.enums.IntegerEnum.ONE;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ssreddy.booking.common.BookingConstants;
import com.ssreddy.booking.common.enums.IntegerEnum;
import com.ssreddy.booking.model.ResponseObject;
import com.ssreddy.booking.model.Status;

/**
 * Author : Shaymsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Class to handle exceptions. <br>
 * JIRA: <br>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * messageSource instance of MessageSource.
	 */
	@Autowired
	@Qualifier("messageSource")
	MessageSource messageSource;

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseObject handleException(Exception exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(INT_500.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseObject handleCRMException(BookingException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(IntegerEnum.INT_500.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingInternalException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseObject handleCRMInternalException(BookingInternalException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(INT_500.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingBusinessValidationException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ResponseBody
	public ResponseObject handleCRMBusinessValidationException(BookingBusinessValidationException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(INT_412.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingDataNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseObject handleCRMDataNotFoundException(BookingDataNotFoundException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(INT_204.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param request
	 *            instance of HttpServletRequest.
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseObject handleMethodArgumentNotValidException(HttpServletRequest request,
			MethodArgumentNotValidException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		Locale locale = request.getLocale();
		LOGGER.debug("Locale > " + locale);
		BindingResult result = exp.getBindingResult();
		List<String> errorMessages = result.getAllErrors().stream()
				.map(objectError -> messageSource.getMessage(objectError.getDefaultMessage(), null, locale))
				.collect(Collectors.toList());

		String errString = errorMessages.toString();
		errString = errString.substring(ONE.getValue(), (errString.length() - ONE.getValue()));
		return sendResponse(INT_400.getValue(), errString);
	}

	/**
	 *
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingRequestValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseObject handleCRMRequestValidationException(BookingRequestValidationException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		return sendResponse(INT_400.getValue(), exp.getMessage());
	}

	/**
	 *
	 * @param req
	 *            instance of HttpServletRequest.
	 * @param exp
	 *            instance of Exception.
	 * @return instance of ResponseObject.
	 */
	@ExceptionHandler(BookingDataAccessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseObject handleCRMDataAccessException(HttpServletRequest req, BookingDataAccessException exp) {
		LOGGER.error(EXCEPTION_MSG, exp);
		Locale locale = req.getLocale();
		return sendResponse(INT_500.getValue(), messageSource.getMessage(BookingConstants.PROCESSING_ERR, null, locale));
	}

	/**
	 *
	 * @param code
	 *            instance of String.
	 * @param msg
	 *            instance of String.
	 * @return instance of ResponseObject.
	 */
	public static ResponseObject sendResponse(String code, String msg) {
		ResponseObject resp = new ResponseObject();
		Status status = getStatus(code, msg);
		resp.setStatus(status);
		return resp;
	}

	/**
	 *
	 * @param code
	 *            instance of int.
	 * @param msg
	 *            instance of String.
	 * @return instance of ResponseObject.
	 */
	public static ResponseObject sendResponse(int code, String msg) {
		return sendResponse(String.valueOf(code), msg);
	}

	/**
	 *
	 * @param code
	 *            instance of String.
	 * @param msg
	 *            instance of String.
	 * @return instance of Status.
	 */
	public static Status getStatus(String code, String msg) {
		Status status = new Status();
		status.setCode(code);
		status.setMessage(msg);
		return status;
	}

}
