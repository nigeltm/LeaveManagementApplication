package com.posb.LeaveManagement.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
	private int status;
	private String message;
	private Date timestamp;
	private String path;
	private Map<String,String> validationErrors;

	public ApiError(int status, String message, String path) {
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
		this.path = path;
	}
}
