package com.example.demo.exception;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class ExceptionHandlerC extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> PLSQLException(SQLException ex, WebRequest request){
		//ErrorDetails error = new ErrorDetails(new Date(0),ex.getMessage(), request.getDescription(false));
		//return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		return null;
		
	}

}
