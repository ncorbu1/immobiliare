package org.example.exception;

public class InvalidActivationCodeException extends RuntimeException {

	private static final long serialVersionUID = -6855870110957747045L;

	public InvalidActivationCodeException() {
		super();
	}

	public InvalidActivationCodeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidActivationCodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidActivationCodeException(String message) {
		super(message);
	}

	public InvalidActivationCodeException(Throwable cause) {
		super(cause);
	}

}
