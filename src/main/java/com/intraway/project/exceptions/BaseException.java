package com.intraway.project.exceptions;

import com.intraway.project.exceptions.errors.ErrorEnum;

public class BaseException extends RuntimeException {

	public BaseException(ErrorEnum error, Object... args) {
		super(String.format(error.getMessage(), args));
	}
}