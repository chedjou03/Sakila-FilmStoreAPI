package com.FilmStoreAPI.error;

public class EntityAlreadyExistedException extends RuntimeException 
{

	public EntityAlreadyExistedException() {
		super();
	}

	public EntityAlreadyExistedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityAlreadyExistedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityAlreadyExistedException(String message) {
		super(message);
	}

	public EntityAlreadyExistedException(Throwable cause) {
		super(cause);
	}
	

}
