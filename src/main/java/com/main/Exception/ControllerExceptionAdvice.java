package com.main.Exception;

import java.util.*;

import com.main.dto.exception.CustomExpiredJwtException;
import com.main.dto.exception.ErrorDetails;
import com.main.dto.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.main.dto.response.ErrorResponse;

import io.jsonwebtoken.ExpiredJwtException;


@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(CustomExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> handleExpiredJwt(CustomExpiredJwtException ex) {
        ErrorResponse errorResponse = new ErrorResponse("JWT token has expired!", ex.getCustomMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }



    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<ErrorResponse> handleBadCredentialException(BadCredentialsException ex){
        ex.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse("Please check username or password !", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgumentException(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
	    Map<String, String> map = new HashMap<>();
	    
	    ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
	        map.put(fieldError.getField(), fieldError.getDefaultMessage());
	    });
	    
	    return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        exception.printStackTrace();
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		ex.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
