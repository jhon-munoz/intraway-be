package com.intraway.project.exceptions;

import com.intraway.project.exceptions.errors.ErrorEnum;

public class BadRequestException extends BaseException {
	
	public BadRequestException(ErrorEnum error, Object... args) {
		super(error, args);
	}

}
