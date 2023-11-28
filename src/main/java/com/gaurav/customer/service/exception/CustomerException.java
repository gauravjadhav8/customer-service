package com.gaurav.customer.service.exception;

public final class CustomerException extends RuntimeException {
	private static final long serialVersionUID = -2338626292552177445L;

	public CustomerException(final String msg) {
		super(msg);
	}
}