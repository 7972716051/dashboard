package com.party.dashboard.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorTemplate {
    private String message;
    private String statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

}
