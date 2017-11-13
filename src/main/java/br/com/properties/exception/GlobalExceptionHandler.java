package br.com.properties.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.properties.dto.ErrorResponse;
import br.com.properties.dto.ErrorType;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
 
        List<String> reason = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorType.INVALID_DATA_VALUES, reason), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {
	        
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorType.GENERIC, 
        		Arrays.asList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(ProvinceException e) {
        
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorType.BUSINESS, 
        		Arrays.asList(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
