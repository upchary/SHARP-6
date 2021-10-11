/**
 * 
 */
package com.sharp6.exception;

import org.apache.log4j.Logger;


/**
 *
 */
@SuppressWarnings("serial")
public class KPOSTWebServiceException extends Exception {
	
	private static final Logger logger = Logger.getLogger(KPOSTWebServiceException.class);

	/**
	 * 
	 */

	private String message = null;
	private String erroCode = null;

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	

	public String getErroCode() {
		return erroCode;
	}

	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public KPOSTWebServiceException() {
	}
	
	/**
	 * @param message
	 */
	public KPOSTWebServiceException(String erroCode , String message ) {
		super(message);
		logger.error("Exception issued by KPOST Webservice  "+erroCode+"  "+message);
		this.message=message;
		this.erroCode=erroCode;
	}

	/**
	 * @param message
	 */
	public KPOSTWebServiceException(String message) {
		super(message);
		this.message=message;
	}

	/**
	 * @param cause
	 */
	public KPOSTWebServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public KPOSTWebServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public KPOSTWebServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
