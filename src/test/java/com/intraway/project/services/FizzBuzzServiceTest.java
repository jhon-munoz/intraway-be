package com.intraway.project.services;

import com.intraway.project.domains.FizzBuzz;
import com.intraway.project.dtos.ResponseDTO;
import com.intraway.project.exceptions.BadRequestException;
import com.intraway.project.exceptions.errors.ErrorEnum;
import com.intraway.project.repositories.FizzBuzzRepository;
import com.intraway.project.services.Impl.FizzBuzzServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceTest {

	public static final Integer MIN = 1;
	public static final Integer MAX = 10;
	public static final Long CODE = 1L;
	public static final Long TIMESTAMP = 123L;
	public static final String DESCRIPTION = "se encontraron múltiplos de 3 y de 5";
	public static final String LIST = "[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz]";

	@InjectMocks
	FizzBuzzServiceImpl fizzBuzzService;

	@Mock
	FizzBuzzRepository fizzBuzzRepository;

	@Mock
	ModelMapper mapper;

	@Test
	public void shouldSuccess_whenCalling_getList_and_Fizz_Buzz_Response() {
		Mockito.when(fizzBuzzRepository.save(Mockito.any())).thenReturn(fizzBuzz());
		doReturn(new ModelMapper().map(fizzBuzz(), ResponseDTO.class))
				.when(mapper).map(any(FizzBuzz.class), any(Class.class));

		ResponseDTO response = fizzBuzzService.getList(MIN, MAX);

		assertNotNull(response);
		assertEquals(response.getCode(), CODE);
		assertEquals(response.getTimestamp(), TIMESTAMP);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getList(), LIST);
	}

	@Test
	public void shouldSuccess_whenCalling_getList_and_FizzBuzz_Response() {
		Mockito.when(fizzBuzzRepository.save(Mockito.any())).thenReturn(fizzBuzz());
		doReturn(new ModelMapper().map(fizzBuzz(), ResponseDTO.class))
				.when(mapper).map(any(FizzBuzz.class), any(Class.class));

		ResponseDTO response = fizzBuzzService.getList(MIN, 15);

		assertNotNull(response);
		assertEquals(response.getCode(), CODE);
		assertEquals(response.getTimestamp(), TIMESTAMP);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getList(), LIST);
	}

	@Test
	public void shouldSuccess_whenCalling_getList_and_Fizz_Response() {
		Mockito.when(fizzBuzzRepository.save(Mockito.any())).thenReturn(fizzBuzz());
		doReturn(new ModelMapper().map(fizzBuzz(), ResponseDTO.class))
				.when(mapper).map(any(FizzBuzz.class), any(Class.class));

		ResponseDTO response = fizzBuzzService.getList(MIN, 4);

		assertNotNull(response);
		assertEquals(response.getCode(), CODE);
		assertEquals(response.getTimestamp(), TIMESTAMP);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getList(), LIST);
	}

	@Test
	public void shouldSuccess_whenCalling_getList_and_Buzz_Response() {
		Mockito.when(fizzBuzzRepository.save(Mockito.any())).thenReturn(fizzBuzz());
		doReturn(new ModelMapper().map(fizzBuzz(), ResponseDTO.class))
				.when(mapper).map(any(FizzBuzz.class), any(Class.class));

		ResponseDTO response = fizzBuzzService.getList(4, 5);

		assertNotNull(response);
		assertEquals(response.getCode(), CODE);
		assertEquals(response.getTimestamp(), TIMESTAMP);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getList(), LIST);
	}

	@Test
	public void shouldSuccess_whenCalling_getList_and_NoFizzBuzz_Response() {
		Mockito.when(fizzBuzzRepository.save(Mockito.any())).thenReturn(fizzBuzz());
		doReturn(new ModelMapper().map(fizzBuzz(), ResponseDTO.class))
				.when(mapper).map(any(FizzBuzz.class), any(Class.class));

		ResponseDTO response = fizzBuzzService.getList(MIN, 2);

		assertNotNull(response);
		assertEquals(response.getCode(), CODE);
		assertEquals(response.getTimestamp(), TIMESTAMP);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getList(), LIST);
	}

	@Test
	public void shouldFail_whenCalling_getList() {
		try {
			fizzBuzzService.getList(MAX, MIN);
		}catch (BadRequestException ex){
			assertEquals(ErrorEnum.INCORRECT_PARAMETER.getMessage(), ex.getMessage());
		}
	}

	@Test
	public void shouldFail_whenCalling_getList_GeneralError() {
		try {
			fizzBuzzService.getList(MIN, MAX);
		}catch (Exception ex){
			assertEquals(ErrorEnum.INCORRECT_PARAMETER.getMessage(), ex.getMessage());
		}
	}

	public FizzBuzz fizzBuzz() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		fizzBuzz.setCode(CODE);
		fizzBuzz.setTimestamp(TIMESTAMP);
		fizzBuzz.setDescription(DESCRIPTION);
		fizzBuzz.setList(LIST);
		return fizzBuzz;
	}

}
