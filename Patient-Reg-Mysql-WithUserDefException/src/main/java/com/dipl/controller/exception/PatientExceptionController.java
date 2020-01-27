package com.dipl.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PatientExceptionController {
	
@ExceptionHandler(value = PatientNotFoundException.class)
public ResponseEntity<Object> exception(PatientNotFoundException exception) {
   return new ResponseEntity<>("Sorry... YOU HAVE ENTERED AN INVALID REGISTRATION NUMBER"+"\n"+"Please !!.. ENTER A VALID REGISTRATION NUMBER", HttpStatus.NOT_FOUND);
}	

}			
