package com.intraway.project.services;

import com.intraway.project.services.Impl.FizzBuzzServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceTest {

	public static final Long ACCOUNT = 123L;
	public static final Long DEST_ACCOUNT = 124L;
	public static final Double AMOUNT = 50.0;
	public static final String CURRENCY = "USD";
	public static final Integer TRANSACTION = 1;

	@InjectMocks
	FizzBuzzServiceImpl fizzBuzzService;





}
