package com.intraway.project.handlers;

import com.intraway.project.constants.Constants;
import com.intraway.project.dtos.ErrorResponseDTO;
import com.intraway.project.exceptions.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

	@ExceptionHandler(value = BadRequestException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponseDTO badRequestException(BadRequestException ex, HttpServletRequest request) {
		log.error("Bad request Exception " + ex.getMessage(), ex);
		return ErrorResponseDTO.build(HttpStatus.BAD_REQUEST.value(), Constants.BAD_REQUEST, ex.getClass().getName(), ex.getMessage(), request.getRequestURI());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponseDTO> internalServerException(Exception ex, HttpServletRequest request) {
		log.error("Internal server Error " + ex.getMessage(), ex);
		return new ResponseEntity<>(ErrorResponseDTO.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.INTERNAL_ERROR, ex.getClass().getName(), ex.getMessage(), request.getRequestURI()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
