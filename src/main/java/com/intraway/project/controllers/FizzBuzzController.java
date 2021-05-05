package com.intraway.project.controllers;

import com.intraway.project.dtos.ResponseDTO;
import com.intraway.project.services.FizzBuzzService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fizzbuzz")
@Slf4j
public class FizzBuzzController {

	@Autowired
	FizzBuzzService fizzBuzzService;

	@ApiOperation(value = "Returns a list with the characteristics of each number from a range")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Return the list"),
			@ApiResponse(code = 500, message = "Unexpected error has occurred.")})
	@GetMapping("/{min}/{max}")
	public ResponseEntity<ResponseDTO> getList(
			@ApiParam(value = "Minimum integer number" )
			@PathVariable Integer min,
			@ApiParam(value = "Maximum integer number")
			@PathVariable Integer max ) {
		ResponseEntity<ResponseDTO> response;
		response = new ResponseEntity<>(fizzBuzzService.getList(min, max), HttpStatus.OK);
		return response;
	}
}
