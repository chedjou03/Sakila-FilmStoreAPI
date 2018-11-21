package com.FilmStoreAPI.Entity.CustomerData;

public class EntityErrorResponse 
{
	private int status;
	private String message;
	private long timeStamp;
	
	
	public EntityErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	
	public EntityErrorResponse() {
		super();
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "StudentErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
}