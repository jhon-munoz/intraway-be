package com.intraway.project.handlers;

import com.intraway.project.controllers.FizzBuzzController;
import com.intraway.project.exceptions.BadRequestException;
import com.intraway.project.exceptions.errors.ErrorEnum;
import com.intraway.project.services.FizzBuzzService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
public class ControllerAdvisorTest {

	public static final Integer MIN = 1;
	public static final Integer MAX = 10;

	@Mock
	private FizzBuzzService fizzBuzzService;

	@InjectMocks
	private FizzBuzzController fizzBuzzController;

	private MockMvc mvc;

	private ExceptionHandlerExceptionResolver createExceptionResolver() {
		ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
			@Override
			protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
				Method method = new ExceptionHandlerMethodResolver(
						ControllerAdvisor.class).resolveMethod(exception);
				return new ServletInvocableHandlerMethod(
						new ControllerAdvisor(), method);
			}
		};
		exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		exceptionResolver.afterPropertiesSet();
		return exceptionResolver;
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(fizzBuzzController)
				.setHandlerExceptionResolvers(createExceptionResolver())
				.build();
	}

	@Test
	public void shouldFail_whenGetList_thenReturnBadRequestResponse() throws Exception {
		when(fizzBuzzService.getList(MAX, MIN)).thenThrow(new BadRequestException(ErrorEnum.INCORRECT_PARAMETER));
		mvc.perform(get("/fizzbuzz/" + MAX + "/" + MIN)).andExpect(status().isBadRequest());
	}

	@Test
	public void shouldFail_whenUnexpectedError_thenReturnInternalServerError() throws Exception {
		when(fizzBuzzService.getList(MAX, MIN)).thenThrow(new IllegalStateException("test"));
		mvc.perform(get("/fizzbuzz/" + MAX + "/" + MIN)).andExpect(status().isInternalServerError());
	}

}
