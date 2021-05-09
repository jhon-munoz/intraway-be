package com.intraway.project.controllers;

import com.intraway.project.constants.Constants;
import com.intraway.project.dtos.ErrorResponseDTO;
import com.intraway.project.dtos.ResponseDTO;
import com.intraway.project.services.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzControllerTest {

	public static final Integer MIN = 1;
	public static final Integer MAX = 10;
	public static final Long CODE = 1L;
	public static final Long TIMESTAMP = 123L;
	public static final String DESCRIPTION = "se encontraron múltiplos de 3 y de 5";
	public static final String LIST = "[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz]";

	@InjectMocks
	FizzBuzzController fizzBuzzController;

	@Mock
	FizzBuzzService service;

	@Test
	public void shouldSuccess_whenCalling_getList(){
		when(service.getList(MIN,MAX)).thenReturn(responseDTO());
		ResponseEntity<ResponseDTO> response = fizzBuzzController.getList(MIN, MAX);

		assertNotNull(response);
		assertEquals(response.getBody().getCode(), CODE);
		assertEquals(response.getBody().getTimestamp(), TIMESTAMP);
		assertEquals(response.getBody().getDescription(), DESCRIPTION);
		assertEquals(response.getBody().getList(), LIST);
	}

	public ResponseDTO responseDTO() {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setCode(CODE);
		responseDTO.setTimestamp(TIMESTAMP);
		responseDTO.setDescription(DESCRIPTION);
		responseDTO.setList(LIST);
		return responseDTO;
	}

	public ErrorResponseDTO errorResponseDTO(){
		ErrorResponseDTO errorResponseDTO=new ErrorResponseDTO();
		errorResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponseDTO.setError(Constants.BAD_REQUEST);
		errorResponseDTO.setException("Bad");
		errorResponseDTO.setMessage("Bad Message");
		errorResponseDTO.setPath("/intraway/api/fizzbuzz/");
		return errorResponseDTO;
	}

}
