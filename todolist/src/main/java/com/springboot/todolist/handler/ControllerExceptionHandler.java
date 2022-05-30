package com.springboot.todolist.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.todolist.web.dto.CMRespDto;
import com.springboot.todolist.handler.ex.CustomValidationApiException;

@RestController
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e){
		return new ResponseEntity<>(new CMRespDto<Map<String,String>>(-1,e.getMessage(),e.getErrorMap()),HttpStatus.BAD_REQUEST);
	}
}
