package com.intraway.project.controllers;

import com.intraway.project.services.FizzBuzzService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzControllerTest {

	public static final Long ACCOUNT = 123L;
	public static final Long DEST_ACCOUNT = 124L;
	public static final Double AMOUNT = 1.23;
	public static final String CURRENCY = "USD";

	@InjectMocks
	FizzBuzzController fizzBuzzController;

	@Mock
	FizzBuzzService service;


}
