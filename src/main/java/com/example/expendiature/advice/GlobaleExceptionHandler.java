package com.example.expendiature.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.expendiature.entity.ErrorObject;
import com.example.expendiature.exception.IdNotPresentException;
import com.example.expendiature.exception.NoRecordsFoundException;


@RestControllerAdvice
public class GlobaleExceptionHandler {

	@ExceptionHandler(NoRecordsFoundException.class)
	public ResponseEntity<ErrorObject> handleNoRecordsFoundException(NoRecordsFoundException ex) {
		ErrorObject eObj = new ErrorObject();
		eObj.setHttpStatus(HttpStatus.NOT_FOUND.value());
		eObj.setMassage(ex.getMessage());

		return new ResponseEntity<ErrorObject>(eObj, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IdNotPresentException.class)
	public ResponseEntity<ErrorObject> handleIdNotPresentException(IdNotPresentException ex) {
		ErrorObject eObj1 = new ErrorObject();
		eObj1.setHttpStatus(HttpStatus.NOT_FOUND.value());
		eObj1.setMassage(ex.getMessage());

		return new ResponseEntity<ErrorObject>(eObj1, HttpStatus.NOT_FOUND);
	}
}
