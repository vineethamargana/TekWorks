package com.bank.sys.dto;

import java.util.Date;

public class ApiResponse<T> {
	private Date timestamp;
    private String message;
    private T data;

    public ApiResponse(String message,T data) {
    	this.timestamp = new Date();
    	this.message = message;
    	this.data = data;
	}
 
	public ApiResponse(String message) {
    	this.timestamp = new Date();
        this.message = message;
      //  this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
