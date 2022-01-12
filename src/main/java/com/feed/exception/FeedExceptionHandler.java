package com.feed.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController  
public class FeedExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FeedNotFoundException.class)
	
	public ResponseEntity<FeedErrorMessage> resourceNotFoundException(FeedNotFoundException ex, WebRequest request) {
		FeedErrorMessage message = new FeedErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<FeedErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }

	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<FeedErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		  FeedErrorMessage message = new FeedErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<FeedErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	  
	  @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
		  FeedErrorMessage exceptionResponse= new FeedErrorMessage(HttpStatus.BAD_REQUEST.value(),new Date(), "Validation Failed", ex.getBindingResult().toString());  
		//returning exception structure and specific status   
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);  
		}
	  
	  
	
}
