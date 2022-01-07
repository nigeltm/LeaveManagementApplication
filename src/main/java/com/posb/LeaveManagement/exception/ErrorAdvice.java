package com.posb.LeaveManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request){
		ApiError error = new ApiError(404, exception.getMessage(), request.getServletPath());
		return error;
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleBadRequestException(BadRequestException exception, HttpServletRequest request){
		ApiError error  = new ApiError(400, exception.getMessage(), request.getServletPath());
		return error;
	}
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleConstraintViolationException(ConstraintViolationException exception,HttpServletRequest request){
		ApiError error = new ApiError(400,exception.getMessage(), request.getServletPath());
		Map<String,String>  validationErrors = new HashMap<>();
		for(ConstraintViolation violation: exception.getConstraintViolations()){
			validationErrors.put(String.valueOf(violation.getPropertyPath()), violation.getMessage());
		}
		error.setMessage("Validation failed.");
		error.setValidationErrors(validationErrors);
		return error;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,HttpServletRequest request){
		ApiError error = new ApiError(400, exception.getMessage(), request.getServletPath());
		Map<String, String> validationErrors= new HashMap<>();
		BindingResult bindingResult = exception.getBindingResult();
		for (FieldError fieldError: bindingResult.getFieldErrors()){
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		error.setMessage("Validation errors encountered.");
		return error;
	}



}
