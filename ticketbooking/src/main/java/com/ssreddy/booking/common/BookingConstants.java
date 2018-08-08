package com.ssreddy.booking.common;

/**
 * Author : Shyamsundar T <br>
 * Created on : 05th Aug, 2018 <br>
 * Version : 1.0. <br>
 * Description : Maintains constants used in Ticket Booking management. <br>
 * JIRA: <br>
 */
public class BookingConstants {

	/**
	 * Constructor.
	 */
	private BookingConstants() {
		// this prevents even the native class from
		// calling this actor as well :
		throw new AssertionError();
	}

	/**
	 * COOKIE instance of String.
	 */
	public static final String COOKIE = "cookie";

	/**
	 * EQUALSTRING instance of String.
	 */
	public static final String EQUALSTRING = "=";

	/**
	 * EMPTYSTRING instance of String.
	 */
	public static final String EMPTYSTRING = "";

	/**
	 * STRING_ZERO instance of String.
	 */
	public static final String STRING_ZERO = "0";

	/**
	 * STRING_ONE instance of String.
	 */
	public static final String STRING_ONE = "1";

	/**
	 * CHAR_ONE instance of char.
	 */
	public static final char CHAR_ONE = '1';

	/**
	 * BYTE_ZERO instance of byte.
	 */
	public static final byte BYTE_ZERO = 0;

	/**
	 * BYTE_ONE instance of byte.
	 */
	public static final byte BYTE_ONE = 1;

	/**
	 * STRING_TWO instance of String.
	 */
	public static final String STRING_TWO = "2";

	/**
	 * STRING_THREE instance of String.
	 */
	public static final String STRING_THREE = "3";
 
	/**
	 * CONTENT_TYPE instance of String.
	 */
	public static final String CONTENT_TYPE = "Content-Type";

	/**
	 * ACCEPT instance of String.
	 */
	public static final String ACCEPT = "accept";

	/**
	 * SUCSESS instance of String.
	 */
	public static final String SUCCESS = "SUCCESS";

	/**
	 * FAILURE instance of String.
	 */
	public static final String FAILURE = "FAILURE";

	/**
	 * STATUS_200 instance of String.
	 */
	public static final String STATUS_200 = "200";

	/**
	 * STATUS_204 instance of String.
	 */
	public static final String STATUS_204 = "204";

	/**
	 * STATUS_400 instance of String.
	 */
	public static final String STATUS_400 = "400";

	/**
	 * STATUS_412 instance of String.
	 */
	public static final String STATUS_412 = "412";

	/**
	 * STATUS_500 instance of String.
	 */
	public static final String STATUS_500 = "500";

	/**
	 * OK instance of String.
	 */
	public static final String OK = "OK";

	/**
	 * NO_CONTENT instance of String.
	 */
	public static final String NO_CONTENT = "No Content";

	/**
	 * BAD_REQUEST instance of String.
	 */
	public static final String BAD_REQUEST = "Bad Request";

	/**
	 * PRECONDITION_FAILED instance of String.
	 */
	public static final String PRECONDITION_FAILED = "Precondition Failed";

	/**
	 * INTERNAL_SERVER_ERROR instance of String.
	 */
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

	/**
	 * REQ_ATTRIBUTE_USERID instance of String.
	 */
	public static final String REQ_ATTRIBUTE_USERID = "userId";

	/**
	 * ST_TOKEN instance of String.
	 */
	public static final String ST_TOKEN = "st_token";

	/**
	 * SPECIAL_CHAR_VALIDATION instance of String.
	 */
	public static final String SPECIAL_CHAR_VALIDATION = "special.char.validation";

	/**
	 * MAXNUMOFQUOTES instance of String.
	 */
	public static final String MAXNUMOFQUOTES = "z9";

	/**
	 * IDMAXGLOBALINDEX instance of String.
	 */
	public static final String IDMAXGLOBALINDEX = "99";

	/**
	 * MOBILECFNEXTN instance of String.
	 */
	public static final String MOBILECFNEXTN = "M00";

	/**
	 * TGT_TOKEN instance of String.
	 */
	public static final String TGT_TOKEN = "tgt_token";

	/**
	 * COMMAND_PARAMETER instance of String.
	 */
	public static final String COMMAND_PARAMETER = "command";

	/**
	 * SERVER_NAME instance of String.
	 */
	public static final String SERVER_NAME = "CRM";

	/**
	 * Countered instance of String.
	 */
	public static final String COUNTERED = "Countered";

	/**
	 * DRAFT instance of String.
	 */
	public static final String DRAFT = "Draft";

	/**
	 * PIPE_SYMBOL instance of String.
	 */
	public static final String PIPE_SYMBOL = "|";

	/**
	 * HIPHEN instance of String.
	 */
	public static final String HIPHEN = "-";

	/**
	 * UNDER_SCORE instance of String.
	 */
	public static final String UNDER_SCORE = "_";

	/**
	 * EXPECTED_DATE_PATTERN instance of String.
	 */
	public static final String EXPECTED_DATE_PATTERN = "HH:mm, dd MMM yyyy";

	/**
	 * ORIGINAL_DATE_PATTERN instance of String.
	 */
	public static final String ORIGINAL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
	
	/**
	 * DATE instance of String.
	 */
	public static final String DATE = "{\"date\": \"";

	/**
	 * NOOFDAYS instance of String.
	 */
	public static final String NOOFDAYS = "\",\"noOfDays\": \"";

	/**
	 * ENDDATEFORMAT instance of String.
	 */
	public static final String ENDDATEFORMAT = "\"}";

	/**
	 * MON instance of String.
	 */
	public static final String MON = "MON";

	/**
	 * DATEFORMAT instance of String.
	 */
	public static final String DATEFORMAT = "date";

	/**
	 * NOOFDAYSFORMAT instance of String.
	 */
	public static final String NOOFDAYSFORMAT = "noOfDays";

	/**
	 * MORE_THAN_MAXDATE instance of String.
	 */
	public static final String MORE_THAN_MAXDATE = "more.than.max.date";

	/**
	 * EXCEPTION_MSG instance of String.
	 */
	public static final String EXCEPTION_MSG = "Exception occurred";

	/**
	 * NO_RECORD_FOUND instance of String.
	 */
	public static final String NO_RECORD_FOUND = "no.record.found";

	/**
	 * UTF_8 instance of String.
	 */
	public static final String UTF_8 = "UTF-8";

	/**
     * PROCESSING_ERR instance of String.
     */
    public static final String PROCESSING_ERR = "processing.error";
}
